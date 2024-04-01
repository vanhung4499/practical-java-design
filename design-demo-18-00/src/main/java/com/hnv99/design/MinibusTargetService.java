package com.hnv99.design;

/**
 * Dịch vụ điều chỉnh chỉ tiêu xe khách nhỏ
 */
public class MinibusTargetService {

    /**
     * Mô phỏng việc quay số, nhưng không phải là thuật toán quay số
     *
     * @param uId Số thứ tự người dùng
     * @return Kết quả
     */
    public String lottery(String uId) {
        return Math.abs(uId.hashCode()) % 2 == 0 ? "Chúc mừng bạn, mã".concat(uId).concat("đã trúng trong quá trình quay số lần này") : "Rất tiếc, mã".concat(uId).concat("không trúng hoặc đã hết hạn tham gia quay số lần này");
    }

}
