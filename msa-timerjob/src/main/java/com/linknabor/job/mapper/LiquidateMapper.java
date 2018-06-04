package com.linknabor.job.mapper;

import com.linknabor.job.service.liquidate.model.MchInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LiquidateMapper {

    //根据清算日期，获取待清算的线上交易
    List<MchInfo> getLiquidateMch(@Param("plat_channel") String plat_channel, @Param("liquidate_date") String liquidate_date, @Param("payMethods") String[] payMethods);

    //根据清算日期，获取待清算的现金交易
    List<Object> getLiquidateCashTrade(@Param("plat_channel") String plat_channel, @Param("liquidate_date") String liquidate_date, @Param("payMethods") String[] payMethods);

    //根据POS凭证号，查询指定交易
    String getTradeByVoucherNo(@Param("voucher_no") String voucher_no);

}
