package com.linknabor.job.mapper;

import com.linknabor.job.model.MsaCfgMchInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface MsaCfgMchInfoMapper {
    int deleteByPrimaryKey(String mchId);

    int insertSelective(MsaCfgMchInfo record);

    MsaCfgMchInfo selectByPrimaryKey(String mchId);

    int updateByPrimaryKeySelective(MsaCfgMchInfo record);

    MsaCfgMchInfo selectByCustIdAndMchNo(String custId, String mchNo);


}