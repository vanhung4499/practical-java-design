package com.hnv99.design.impl;

import com.hnv99.design.ICouponDiscount;

import java.math.BigDecimal;

public class NYGCouponDiscount implements ICouponDiscount<Double> {

    /**
     * Mua với giá N đô la
     * 1. Mua với giá cố định, không quan tâm giá gốc là bao nhiêu
     */
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        return new BigDecimal(couponInfo);
    }

}
