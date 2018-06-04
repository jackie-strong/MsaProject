package com.linknabor.job.service.liquidate.impl;


import com.linknabor.cloud.msa.common.exception.BaseException;
import com.linknabor.cloud.msa.common.utils.SignUtil;
import com.linknabor.cloud.msa.common.utils.StringHelper;
import com.linknabor.cloud.msa.common.utils.UUIDUtils;
import com.linknabor.job.constant.LiquidateConfigConstant;
import com.linknabor.job.mapper.LiquidateMapper;
import com.linknabor.job.service.liquidate.LiquidateService;
import com.linknabor.job.service.liquidate.model.LiquidateData;
import com.linknabor.job.service.liquidate.model.MchInfo;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 兴业线上交易清算
 * Created by jackeie on 2018.05.14
 */
@Service("xingyeOnLineLiquidate")
public class XingyeOnLineLiquidate implements LiquidateService {

    @Autowired
    LiquidateMapper liquidateMapper;
    @Autowired
    private RestTemplate restTemplate;

    @Value("${liquidate.xingyeonlinepath}")
    private String path;

    public List<LiquidateData> pullLiquidateFile(String liquidate_date) {

        List<MchInfo> listMch = liquidateMapper.getLiquidateMch(LiquidateConfigConstant.Swiftpass, liquidate_date, LiquidateConfigConstant.SwiftPassPayMethod);

        List<LiquidateData> liquidateList = new ArrayList<LiquidateData>();
        for (int i = 0; i < listMch.size(); i++) {
            MchInfo mch_info = listMch.get(i);
            if (mch_info == null || StringUtils.isEmpty(mch_info.getMch_id()) || "0".equals(mch_info.getMch_id())) {
                continue;
            }
            try {
                //1.下载文件
                String fileName = downloadXingYeFile(mch_info);
                //2.读取文件
                liquidateList = readXingYeFile(fileName);

            } catch (Exception e) {
                throw new BaseException("", e);
            }
        }
        return liquidateList;
    }

    /**
     * 下载兴业线上支付清算文件
     *
     * @param mch_info
     * @return
     * @throws Exception
     */
    public String downloadXingYeFile(MchInfo mch_info) throws Exception {

        String mch_id = mch_info.getMch_id(); //威富通商户号
        String key = mch_info.getSecret(); //威富通支付密钥
        String liquidate_date = mch_info.getAcct_date(); //清算日期

        String nonce_str = UUIDUtils.getUuid(); //获取唯一随机数

        Map map = new TreeMap<String, String>();
        map.put("bill_date", liquidate_date);
        map.put("bill_type", "ALL");
        map.put("mch_id", mch_id);  //商户号
        map.put("nonce_str", nonce_str);  //随机字符串
        map.put("service", LiquidateConfigConstant.swiftPassDownloadService); //
        String sign = SignUtil.createSign(map, key);
        map.put("sign", sign);

        String requestXml = StringHelper.createRequestXML(map);

        String responseStr = restTemplate.postForEntity(LiquidateConfigConstant.swiftPassDownloadUrl, map, String.class).getBody();

        String fileName = path + liquidate_date + "-" + mch_info.getMch_id() + ".dat";
        FileUtils.writeStringToFile(new File(fileName), responseStr, LiquidateConfigConstant.INPUT_CHARSET);
        return fileName;
    }

    /**
     * 读取兴业线上支付清算文件
     *
     * @param fileName
     */
    public List<LiquidateData> readXingYeFile(String fileName) throws Exception {
        List<String> dataList = FileUtils.readLines(new File(fileName), LiquidateConfigConstant.INPUT_CHARSET);
        if (dataList.size() > 2) {
            // 头丢掉
            dataList.remove(0);
            // 丢掉尾部汇总的2行
            dataList.remove(dataList.size() - 1);
            dataList.remove(dataList.size() - 1);
        }

        List<LiquidateData> list = new ArrayList<LiquidateData>();
        for (String data : dataList) {
            String[] cellDatas = data.split("`");
            List<String> cellDataList = new ArrayList<String>();
            for (String cellData : cellDatas) {
                cellData = cellData.trim().replace(",", "");
                cellDataList.add(cellData);
            }

            LiquidateData liquidateData = new LiquidateData();
            // 商户订单号对应我们系统的TradeWaterId
            liquidateData.setTradeWaterId(cellDataList.get(9));
            liquidateData.setRate(getListDecimalData(cellDataList, 26));
            liquidateData.setRateAmt(getListDecimalData(cellDataList, 25));
            liquidateData.setTramAmt(getListDecimalData(cellDataList, 15));
            liquidateData.setTranStatus(getListData(cellDataList, 12));
            liquidateData.setTranStatus(getListData(cellDataList, 22));
            list.add(liquidateData);
        }
        return list;
    }

    private static String getListData(List<String> cellDataList, int i) {

        if (cellDataList.size() < i) {
            throw new BaseException("无法读取第" + i + "个数据，原始数据：" + cellDataList);
        }
        return cellDataList.get(i);
    }

    private static BigDecimal getListDecimalData(List<String> cellDataList, int i) {

        String s = getListData(cellDataList, i);
        if (s.indexOf("%") > 0) {
            s = s.replace("%", "");
            return (new BigDecimal(s)).divide(new BigDecimal(100));
        } else {
            return new BigDecimal(s);
        }
    }
}
