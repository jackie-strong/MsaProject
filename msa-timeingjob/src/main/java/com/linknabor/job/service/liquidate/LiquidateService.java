package com.linknabor.job.service.liquidate;

import com.linknabor.job.service.liquidate.model.LiquidateData;
import org.springframework.stereotype.Service;

import java.util.List;

public interface LiquidateService<T> {

    List<T> pullLiquidateFile(String liquidate_date);
}
