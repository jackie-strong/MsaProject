package com.linknabor.job.service.liquidate.impl;

import com.linknabor.job.service.liquidate.LiquidateService;
import com.linknabor.job.service.liquidate.model.LiquidateData;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 现金清算
 * Created by jackeie on 2018.05.14
 */
@Service
public class CashLiquidate implements LiquidateService {

    public List<LiquidateData> pullLiquidateFile(String liquidate_date) {
        return null;
    }
}
