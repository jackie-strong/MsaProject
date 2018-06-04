package com.linknabor.job.service.liquidate;

import java.util.List;

public interface LiquidateService<T> {

    List<T> pullLiquidateFile(String liquidate_date);
}
