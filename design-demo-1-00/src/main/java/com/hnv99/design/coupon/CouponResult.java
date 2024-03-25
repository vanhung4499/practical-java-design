package com.hnv99.design.coupon;

public class CouponResult {
    private String code;
    private String info;

    public CouponResult(String code, String info) {
        this.code = code;
        this.info = info;
    }

    public String getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
