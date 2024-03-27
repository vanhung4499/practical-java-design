package com.hnv99.design;

import java.util.Date;

public class RebateInfo {

    private String userId;  // ID người dùng
    private String bizId;   // ID doanh nghiệp
    private Date bizTime;   // Thời gian doanh nghiệp
    private String desc;    // Mô tả doanh nghiệp

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public Date getBizTime() {
        return bizTime;
    }

    public void setBizTime(Date bizTime) {
        this.bizTime = bizTime;
    }

    public void setBizTime(String bizTime) {
        // Chuyển đổi từ chuỗi sang ngày và giờ
        this.bizTime = new Date(Long.parseLong(bizTime));
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

