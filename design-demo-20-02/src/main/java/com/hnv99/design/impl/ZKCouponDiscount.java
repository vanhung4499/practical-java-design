package com.hnv99.design.impl;

import com.hnv99.design.ICouponDiscount;

import java.math.BigDecimal;

public class ZKCouponDiscount implements ICouponDiscount<Double> {


    /**
     * Tính toán số tiền giảm giá phần trăm
     * 1. Sử dụng giá sản phẩm nhân với tỷ lệ giảm giá, để được số tiền thanh toán cuối cùng
     * 2. Làm tròn 2 chữ số thập phân
     * 3. Số tiền thanh toán tối thiểu là 1 đô la
     */
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        BigDecimal discountAmount = skuPrice.multiply(new BigDecimal(couponInfo)).setScale(2, BigDecimal.ROUND_HALF_UP);
        if (discountAmount.compareTo(BigDecimal.ZERO) < 1) return BigDecimal.ONE;
        return discountAmount;
    }

}