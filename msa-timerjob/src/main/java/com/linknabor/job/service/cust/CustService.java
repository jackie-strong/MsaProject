package com.linknabor.job.service.cust;

import com.linknabor.job.model.MsaBaseCustInfo;
import com.linknabor.job.model.MsaCfgMchInfo;

public interface CustService {

    int synCustInfo(MsaBaseCustInfo custInfo);

    int synMchInfo(MsaCfgMchInfo mchInfo);
}
