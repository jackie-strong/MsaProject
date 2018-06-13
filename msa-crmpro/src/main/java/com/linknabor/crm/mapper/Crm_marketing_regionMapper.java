package com.linknabor.crm.mapper;

import com.linknabor.crm.model.Crm_marketing_region;

public interface Crm_marketing_regionMapper {
    int deleteByPrimaryKey(Long regionId);

    int insert(Crm_marketing_region record);

    int insertSelective(Crm_marketing_region record);

    Crm_marketing_region selectByPrimaryKey(Long regionId);

    int updateByPrimaryKeySelective(Crm_marketing_region record);

    int updateByPrimaryKey(Crm_marketing_region record);
}