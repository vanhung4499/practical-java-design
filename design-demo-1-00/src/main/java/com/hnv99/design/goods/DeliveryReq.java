package com.hnv99.design.goods;

public class DeliveryReq {
    private String userName;              // Tên người dùng
    private String userPhone;             // Số điện thoại người dùng
    private String sku;                   // SKU hàng hóa
    private String orderId;               // ID đơn hàng

    public DeliveryReq() {
    }

    public DeliveryReq(String userName, String userPhone, String sku, String orderId, String consigneeUserName, String consigneeUserPhone, String consigneeUserAddress) {
        this.userName = userName;
        this.userPhone = userPhone;
        this.sku = sku;
        this.orderId = orderId;
        this.consigneeUserName = consigneeUserName;
        this.consigneeUserPhone = consigneeUserPhone;
        this.consigneeUserAddress = consigneeUserAddress;
    }

    private String consigneeUserName;     // Tên người nhận hàng
    private String consigneeUserPhone;    // Số điện thoại người nhận hàng
    private String consigneeUserAddress;  // Địa chỉ người nhận hàng

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getConsigneeUserName() {
        return consigneeUserName;
    }

    public void setConsigneeUserName(String consigneeUserName) {
        this.consigneeUserName = consigneeUserName;
    }

    public String getConsigneeUserPhone() {
        return consigneeUserPhone;
    }

    public void setConsigneeUserPhone(String consigneeUserPhone) {
        this.consigneeUserPhone = consigneeUserPhone;
    }

    public String getConsigneeUserAddress() {
        return consigneeUserAddress;
    }

    public void setConsigneeUserAddress(String consigneeUserAddress) {
        this.consigneeUserAddress = consigneeUserAddress;
    }
}
