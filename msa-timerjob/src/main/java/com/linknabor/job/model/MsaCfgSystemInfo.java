package com.linknabor.job.model;

public class MsaCfgSystemInfo {
    private String appid;

    private String appkey;

    private String systemState;

    private String systemName;

    private String systemAddr;

    private String systemCustName;

    private String systemTel;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey == null ? null : appkey.trim();
    }

    public String getSystemState() {
        return systemState;
    }

    public void setSystemState(String systemState) {
        this.systemState = systemState == null ? null : systemState.trim();
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName == null ? null : systemName.trim();
    }

    public String getSystemAddr() {
        return systemAddr;
    }

    public void setSystemAddr(String systemAddr) {
        this.systemAddr = systemAddr == null ? null : systemAddr.trim();
    }

    public String getSystemCustName() {
        return systemCustName;
    }

    public void setSystemCustName(String systemCustName) {
        this.systemCustName = systemCustName == null ? null : systemCustName.trim();
    }

    public String getSystemTel() {
        return systemTel;
    }

    public void setSystemTel(String systemTel) {
        this.systemTel = systemTel == null ? null : systemTel.trim();
    }
}