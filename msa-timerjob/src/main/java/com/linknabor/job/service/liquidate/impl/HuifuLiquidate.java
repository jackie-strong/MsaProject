package com.linknabor.job.service.liquidate.impl;

import com.linknabor.cloud.msa.common.exception.BaseException;
import com.linknabor.cloud.msa.common.utils.FtpUtil;
import com.linknabor.job.constant.LiquidateConfigConstant;
import com.linknabor.job.mapper.LiquidateMapper;
import com.linknabor.job.service.liquidate.LiquidateService;
import com.linknabor.job.service.liquidate.model.LiquidateData;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 汇付刷卡清算
 * Created by jackeie on 2018.05.14
 */
@Service
public class HuifuLiquidate implements LiquidateService {

    private static Logger LOGGER = LoggerFactory.getLogger(HuifuLiquidate.class);

    @Autowired
    private LiquidateMapper liquidateMapper;

    public List<LiquidateData> pullLiquidateFile(String liquidate_date) {

        //1.下载文件到本地
        FtpUtil ftp = new FtpUtil(LiquidateConfigConstant.HuiFuPosFtpAddress, LiquidateConfigConstant.HuiFuPosFtpPort,
                LiquidateConfigConstant.HuiFuPosFtpUserName, LiquidateConfigConstant.HuiFuPosFtpPassword, LiquidateConfigConstant.HuiFuPosFtpBasePath);
        //根据清算日期，获取当日的文件
        String getFileName = liquidate_date + "_310000013000000131_ord.csv";
        ftp.downloadFile(getFileName, LiquidateConfigConstant.HuiFuPosDownloadPath);
        LOGGER.info("download file ");
        //2.处理文件，标准化
        List<String> dataList = null;
        try {
            dataList = FileUtils.readLines(new File(LiquidateConfigConstant.HuiFuPosDownloadPath + getFileName), LiquidateConfigConstant.GBK_CHARSET);
        } catch (IOException e) {
            throw new BaseException("", e);
        }
        List<LiquidateData> liquidateList = new ArrayList<LiquidateData>();
        LOGGER.info("read file size :" + dataList.size());
        for (int i = 0; i < dataList.size(); i++) {
            String[] oldStr = dataList.get(i).split(",");
            String tran_status = oldStr[12].trim();
            String voucherNo = oldStr[3].trim();
            String tran_type = oldStr[6].trim();
            if (LiquidateConfigConstant.HuiFuPosSUCCESS.equals(tran_status) && LiquidateConfigConstant.HuiFuPosTranType.equals(tran_type)) {
                LiquidateData data = new LiquidateData();
                String trade_water_id = liquidateMapper.getTradeByVoucherNo(voucherNo);
                LOGGER.info("deal trade_water_id = " + trade_water_id);
                data.setTradeWaterId(trade_water_id);
                data.setTramAmt(new BigDecimal(oldStr[8].trim()));
                data.setRateAmt(new BigDecimal(oldStr[9].trim()));
                data.setTranStatus("0");
                liquidateList.add(data);
            }
        }
        return liquidateList;
    }
}