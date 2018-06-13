package com.linknabor.job.controller;

import com.linknabor.job.service.liquidate.impl.CashLiquidate;
import com.linknabor.job.service.liquidate.impl.HuifuLiquidate;
import com.linknabor.job.service.liquidate.model.LiquidateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TestController {

    @Autowired
    HuifuLiquidate huifuLiquidate;

    @Autowired
    CashLiquidate cashLiquidate;

    @ResponseBody
    @RequestMapping(value = "/a")
    public void a() {
        List<LiquidateData> list = huifuLiquidate.pullLiquidateFile("20180520");
        for (int i = 0; i < list.size(); i++) {
            LiquidateData l = list.get(i);
            System.out.print(l.toString());
        }
    }

    @ResponseBody
    @RequestMapping(value = "/b")
    public void b() {
        List<LiquidateData> list = cashLiquidate.pullLiquidateFile("20180520");
        for (int i = 0; i < list.size(); i++) {
            LiquidateData l = list.get(i);
            System.out.print(l.toString());
        }
    }
}
