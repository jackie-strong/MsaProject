package com.linknabor.job.service.liquidate.impl;

import com.linknabor.job.constant.LiquidateConfigConstant;
import com.linknabor.job.mapper.LiquidateMapper;
import com.linknabor.job.service.liquidate.LiquidateService;
import com.linknabor.job.service.liquidate.model.LiquidateData;
import com.linknabor.job.service.liquidate.model.MchInfo;
import com.linknabor.job.service.liquidate.model.xingye.pos.AcctDetailTrade;
import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 现金清算
 * Created by jackeie on 2018.05.14
 */
@Service("cashLiquidate")
public class CashLiquidate implements LiquidateService {

    private static Logger LOGGER = LoggerFactory.getLogger(CashLiquidate.class);

    @Autowired
    private LiquidateMapper liquidateMapper;

    public List<LiquidateData> pullLiquidateFile(String liquidate_date) {

        List<Object> list = liquidateMapper.getLiquidateCashTrade("", liquidate_date, LiquidateConfigConstant.cashPayMethod);
        LOGGER.info("size:"+ list.size());
        List<LiquidateData> liquidateDataList = new ArrayList<LiquidateData>();
        for (int i =0; i<list.size(); i++) {
            LiquidateData data = new LiquidateData();

            liquidateDataList.add(data);
        }
        return liquidateDataList;
    }
}
