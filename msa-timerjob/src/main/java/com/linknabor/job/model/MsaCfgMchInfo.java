package com.linknabor.job.model;

import org.springframework.stereotype.Repository;

public class MsaCfgMchInfo extends BaseMode{
    private String mchId;

    private String mchState;

    private String mchNo;

    private String mchSecretKey;

    private String appId;

    private String platChannel;

    private String openBankName;

    private String accountName;

    private String bankAccount;

    private String remark;

    private Long storeId;

    private String custId;

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getMchState() {
        return mchState;
    }

    public void setMchState(String mchState) {
        this.mchState = mchState == null ? null : mchState.trim();
    }

    public String getMchNo() {
        return mchNo;
    }

    public void setMchNo(String mchNo) {
        this.mchNo = mchNo == null ? null : mchNo.trim();
    }

    public String getMchSecretKey() {
        return mchSecretKey;
    }

    public void setMchSecretKey(String mchSecretKey) {
        this.mchSecretKey = mchSecretKey == null ? null : mchSecretKey.trim();
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public String getPlatChannel() {
        return platChannel;
    }

    public void setPlatChannel(String platChannel) {
        this.platChannel = platChannel == null ? null : platChannel.trim();
    }

    public String getOpenBankName() {
        return openBankName;
    }

    public void setOpenBankName(String openBankName) {
        this.openBankName = openBankName == null ? null : openBankName.trim();
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount == null ? null : bankAccount.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }
}