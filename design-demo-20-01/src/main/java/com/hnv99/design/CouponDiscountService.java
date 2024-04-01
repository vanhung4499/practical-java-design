package com.hnv99.design;

/**
 * Tính giảm giá của phiếu giảm giá
 * Loại phiếu giảm giá;
 * 1. Giảm trực tiếp
 * 2. Giảm khi đạt mức
 * 3. Phiếu giảm giá
 * 4. Mua n đồng
 */
public class CouponDiscountService {

    public double discountAmount(int type, double typeContent, double skuPrice, double typeExt) {
        // 1. Giảm trực tiếp
        if (1 == type) {
            return skuPrice - typeContent;
        }
        // 2. Giảm khi đạt mức
        if (2 == type) {
            if (skuPrice < typeExt) return skuPrice;
            return skuPrice - typeContent;
        }
        // 3. Phiếu giảm giá
        if (3 == type) {
            return skuPrice * typeContent;
        }
        // 4. Mua n đồng
        if (4 == type) {
            return typeContent;
        }
        return 0D;
    }

}
