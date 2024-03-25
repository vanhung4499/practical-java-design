package com.hnv99.design.coupon;

/**
 * Mô phỏng dịch vụ phiếu giảm giá
 */
public class CouponService {
    /**
     * Phát phiếu giảm giá
     * @param uId ID người dùng
     * @param couponNumber Số lượng phiếu giảm giá
     * @param uuid UUID
     * @return kết quả phát phiếu giảm giá
     */
    public CouponResult sendCoupon(String uId, String couponNumber, String uuid) {
        System.out.println("Mô phỏng việc phát phiếu giảm giá: " + uId + ", " + couponNumber + ", " + uuid);
        return new CouponResult("0000", "Phát thành công");
    }
}
