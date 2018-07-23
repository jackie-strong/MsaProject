package com.linknabor.job.controller.cust;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.linknabor.cloud.msa.common.response.BaseResult;
import com.linknabor.job.model.MsaBaseCustInfo;
import com.linknabor.job.model.MsaCfgMchInfo;
import com.linknabor.job.service.cust.CustService;
import com.linknabor.job.service.cust.impl.vo.CustReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class CustController {

    private static Logger logger = LoggerFactory.getLogger(CustController.class);

    @Autowired
    CustService custService;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * 同步客户信息（注册复核后）
     */
    @RequestMapping(value = "/crm/sysCust", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult synCust(@RequestBody String reqValue) throws IOException {

        MsaBaseCustInfo custInfo = objectMapper.readValue(reqValue, MsaBaseCustInfo.class);

        int s = custService.synCustInfo(custInfo);
        if (s!=1) {
            return BaseResult.fail(0, "请求内容错误");
        }
        return BaseResult.successResult("success");
    }

    /**
     * 同步门店信息
     */
    @RequestMapping(value = "/crm/synStore", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult synStore() {

        return BaseResult.successResult("");
    }

    /**
     * 同步商户信息
     * @param mchInfo
     * @return
     */
    @RequestMapping(value = "/crm/synMch", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult synMch(@RequestBody MsaCfgMchInfo mchInfo) {
        int s = custService.synMchInfo(mchInfo);
        if (s!=1) {
            return BaseResult.fail(0, "请求内容错误");
        }
        return BaseResult.successResult("success");
    }
}
