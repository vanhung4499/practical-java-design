package com.hnv99.design;

import java.math.BigDecimal;

public interface ICouponDiscount<T> {

    /**
     * Tính toán số tiền giảm giá của phiếu
     * @param couponInfo Thông tin giảm giá; giảm trực tiếp, giảm khi đủ điều kiện, giảm giá, mua với giá N yuan
     * @param skuPrice   Giá trị của SKU
     * @return           Số tiền sau khi giảm giá
     */
    BigDecimal discountAmount(T couponInfo, BigDecimal skuPrice);

}
