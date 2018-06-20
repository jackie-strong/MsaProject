package com.linknabor.job.controller.trade;

import org.springframework.web.bind.annotation.*;

/**
 * Create by Jackie on 2018.06.20
 * 同步交易类
 */
@RestController
public class TradeController {

    @RequestMapping(value = "/syn/trade", method = RequestMethod.POST)
    @ResponseBody
    public void synTrade(@RequestBody String s) {

    }
}
