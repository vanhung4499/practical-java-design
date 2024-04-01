package com.hnv99.design.impl;

import com.hnv99.design.ICouponDiscount;

import java.math.BigDecimal;
import java.util.Map;

public class MJCouponDiscount implements ICouponDiscount<Map<String,String>> {

    /**
     * Tính toán số tiền giảm giá khi đủ điều kiện
     * 1. Kiểm tra x đến n sau đó giảm
     * 2. Số tiền thanh toán tối thiểu là 1 đô la
     */
    public BigDecimal discountAmount(Map<String,String> couponInfo, BigDecimal skuPrice) {
        String x = couponInfo.get("x");
        String o = couponInfo.get("n");

        // Nếu giá sản phẩm nhỏ hơn điều kiện, trả về giá gốc của sản phẩm
        if (skuPrice.compareTo(new BigDecimal(x)) < 0) return skuPrice;
        // Kiểm tra số tiền giảm
        BigDecimal discountAmount = skuPrice.subtract(new BigDecimal(o));
        if (discountAmount.compareTo(BigDecimal.ZERO) < 1) return BigDecimal.ONE;

        return discountAmount;
    }
}
