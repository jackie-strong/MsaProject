package com.linknabor.job.mapper;

import com.linknabor.job.model.MsaCfgSystemInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface MsaCfgSystemInfoMapper {
    int deleteByPrimaryKey(String appid);

    int insert(MsaCfgSystemInfo record);

    int insertSelective(MsaCfgSystemInfo record);

    MsaCfgSystemInfo selectByPrimaryKey(String appid);

    int updateByPrimaryKeySelective(MsaCfgSystemInfo record);

    int updateByPrimaryKey(MsaCfgSystemInfo record);
}