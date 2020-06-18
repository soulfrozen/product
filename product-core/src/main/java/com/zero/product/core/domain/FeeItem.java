package com.zero.product.core.domain;

public class FeeItem {

    private String productCode;//产品编码
    private String feeCode;//费用编号
    private String feeName;//费用名称
    private Integer feeOrder;//费用分配顺序
    private String feeTime;//收费节点(1-申请借款时，2-放款时，3-还款时，4-借款结清时)
    private String recCode;//收方编号
    private String payCode;//付方编号

    private String recName;//收方名称
    private String payName;//付方名称
    private String feeType;//费用类型

    private String recAccountType;
    private String payAccountType;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getFeeCode() {
        return feeCode;
    }

    public void setFeeCode(String feeCode) {
        this.feeCode = feeCode;
    }

    public String getFeeName() {
        return feeName;
    }

    public void setFeeName(String feeName) {
        this.feeName = feeName;
    }

    public Integer getFeeOrder() {
        return feeOrder;
    }

    public void setFeeOrder(Integer feeOrder) {
        this.feeOrder = feeOrder;
    }

    public String getFeeTime() {
        return feeTime;
    }

    public void setFeeTime(String feeTime) {
        this.feeTime = feeTime;
    }

    public String getRecCode() {
        return recCode;
    }

    public void setRecCode(String recCode) {
        this.recCode = recCode;
    }

    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode;
    }

    public String getRecName() {
        return recName;
    }

    public void setRecName(String recName) {
        this.recName = recName;
    }

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public String getRecAccountType() {
        return recAccountType;
    }

    public void setRecAccountType(String recAccountType) {
        this.recAccountType = recAccountType;
    }

    public String getPayAccountType() {
        return payAccountType;
    }

    public void setPayAccountType(String payAccountType) {
        this.payAccountType = payAccountType;
    }
}
