package com.linknabor.job.mapper;

import com.linknabor.job.model.MsaBaseCustInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface MsaBaseCustInfoMapper {
    int insertSelective(MsaBaseCustInfo record);

    int deleteByPrimaryKey(String custId);

    int updateByPrimaryKeySelective(MsaBaseCustInfo record);

    MsaBaseCustInfo selectByPrimaryKey(String custId);

    MsaBaseCustInfo selectByOriginId(String originId, String appId);
}