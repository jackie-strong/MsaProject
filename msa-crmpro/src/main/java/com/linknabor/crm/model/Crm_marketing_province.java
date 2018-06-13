package com.linknabor.crm.model;

public class Crm_marketing_province {
    private Long provinceId;

    private String provinceStatus;

    private String provinceName;

    private String provinceShortName;

    private String remark;

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceStatus() {
        return provinceStatus;
    }

    public void setProvinceStatus(String provinceStatus) {
        this.provinceStatus = provinceStatus == null ? null : provinceStatus.trim();
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName == null ? null : provinceName.trim();
    }

    public String getProvinceShortName() {
        return provinceShortName;
    }

    public void setProvinceShortName(String provinceShortName) {
        this.provinceShortName = provinceShortName == null ? null : provinceShortName.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}