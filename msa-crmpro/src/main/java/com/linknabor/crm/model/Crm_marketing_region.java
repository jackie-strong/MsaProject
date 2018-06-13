package com.linknabor.crm.model;

public class Crm_marketing_region {
    private Long regionId;

    private String regionStatus;

    private String regionName;

    private String remark;

    private Long cityId;

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public String getRegionStatus() {
        return regionStatus;
    }

    public void setRegionStatus(String regionStatus) {
        this.regionStatus = regionStatus == null ? null : regionStatus.trim();
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName == null ? null : regionName.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }
}