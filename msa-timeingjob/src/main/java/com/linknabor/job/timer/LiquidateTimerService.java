package com.linknabor.job.timer;

import com.linknabor.cloud.msa.common.exception.BaseException;
import com.linknabor.cloud.msa.common.utils.DateUtils;
import com.linknabor.job.constant.LiquidateConfigConstant;
import com.linknabor.job.service.liquidate.LiquidateService;
import com.linknabor.job.service.liquidate.impl.*;
import com.linknabor.job.service.liquidate.model.LiquidateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LiquidateTimerService {

    @Autowired
    CashLiquidate cashLiquidate;
    @Autowired
    HuifuLiquidate huifuLiquidate;
    @Autowired
    LakalaLiquidate lakalaLiquidate;
    @Autowired
    XingyeOnLineLiquidate xingyeOnLineLiquidate;
    @Autowired
    XingyePosLiquidate xingyePosLiquidate;

    public LiquidateService getLiquidator(String type) {
        if ("01".equals(type)) {
            return cashLiquidate;
        }else if("02".equals(type)) {
            return huifuLiquidate;
        }else if("03".equals(type)) {
            return lakalaLiquidate;
        }else if("04".equals(type)) {
            return xingyeOnLineLiquidate;
        }else if("05".equals(type)) {
            return xingyePosLiquidate;
        } else {
            throw new BaseException("");
        }
    }

    //每天执行一次
    @Scheduled(cron = "")
    public void timerToDay() {
        String liquidate_date = DateUtils.getNextDateByNum(DateUtils.getCurrentTimeStr("yyyyMMdd"), -2);

        for (String type : LiquidateConfigConstant.liquidateQueue) {
            List<LiquidateData> listLiquidate = getLiquidator(type).pullLiquidateFile(liquidate_date);
            //等待处理......

        }
    }
}
