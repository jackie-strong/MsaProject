package com.linknabor.crm.mapper;

import com.linknabor.crm.model.Crm_marketing_city;

public interface Crm_marketing_cityMapper {
    int deleteByPrimaryKey(Long cityId);

    int insert(Crm_marketing_city record);

    int insertSelective(Crm_marketing_city record);

    Crm_marketing_city selectByPrimaryKey(Long cityId);

    int updateByPrimaryKeySelective(Crm_marketing_city record);

    int updateByPrimaryKey(Crm_marketing_city record);
}