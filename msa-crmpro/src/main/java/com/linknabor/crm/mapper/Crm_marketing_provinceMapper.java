package com.linknabor.crm.mapper;

import com.linknabor.crm.model.Crm_marketing_province;

public interface Crm_marketing_provinceMapper {
    int deleteByPrimaryKey(Long provinceId);

    int insert(Crm_marketing_province record);

    int insertSelective(Crm_marketing_province record);

    Crm_marketing_province selectByPrimaryKey(Long provinceId);

    int updateByPrimaryKeySelective(Crm_marketing_province record);

    int updateByPrimaryKey(Crm_marketing_province record);
}