package com.linknabor.job.controller;

import com.linknabor.job.service.liquidate.HuifuLiquidate;
import com.linknabor.job.service.liquidate.model.LiquidateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
public class TestController {

    @Autowired
    HuifuLiquidate huifuLiquidate;

    @ResponseBody
    @RequestMapping(value = "/b")
    public void b() {
        try {
           List<LiquidateData> list =  huifuLiquidate.pullLiquidateFile("20180520");
            for (int i = 0;i<list.size();i++) {
                LiquidateData l = list.get(i);
                System.out.print(l.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
