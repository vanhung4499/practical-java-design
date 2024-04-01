package com.hnv99.design.impl;

import com.hnv99.design.ICouponDiscount;

import java.math.BigDecimal;

public class ZJCouponDiscount implements ICouponDiscount<Double> {

    /**
     * Tính toán số tiền giảm giá trực tiếp
     * 1. Sử dụng giá sản phẩm trừ đi giá giảm giá
     * 2. Số tiền thanh toán tối thiểu là 1 đô la
     */
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        BigDecimal discountAmount = skuPrice.subtract(new BigDecimal(couponInfo));
        if (discountAmount.compareTo(BigDecimal.ZERO) < 1) return BigDecimal.ONE;
        return discountAmount;
    }

}