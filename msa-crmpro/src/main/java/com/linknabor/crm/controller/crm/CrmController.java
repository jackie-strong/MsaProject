package com.linknabor.crm.controller.crm;

import com.linknabor.cloud.msa.common.response.BaseResult;
import com.linknabor.crm.controller.crm.vo.Cust;
import com.linknabor.crm.controller.crm.vo.MchInfo;
import com.linknabor.crm.controller.crm.vo.Store;
import org.springframework.web.bind.annotation.*;

@RestController
public class CrmController {


    /**
     * 同步客户信息
     */
    @RequestMapping(value = "/crm/sysCust", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult synCust(@RequestBody Cust cust) {

        return BaseResult.successResult("");
    }

    /**
     * 同步门店信息
     */
    @RequestMapping(value = "/crm/synStore", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult synStore(@RequestBody Store store) {

        return BaseResult.successResult("");
    }

    /**
     * 同步商户信息
     * @param mchInfo
     * @return
     */
    @RequestMapping(value = "/crm/synMch", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult synMch(@RequestBody MchInfo mchInfo) {
        return BaseResult.successResult("");
    }


}
