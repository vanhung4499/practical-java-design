package com.hnv99.design.ceiling;

import com.hnv99.design.Matter;

import java.math.BigDecimal;

/**
 * Trần nhà
 * Thương hiệu: Công ty trang trí tự động
 * Mô hình: Trần nhà cấp 2
 */
public class LevelTwoCeiling implements Matter {

    public String scene() {
        return "Trần nhà";
    }

    public String brand() {
        return "Công ty trang trí tự động";
    }

    public String model() {
        return "Trần nhà cấp 2";
    }

    public BigDecimal price() {
        return new BigDecimal(850);
    }

    public String desc() {
        return "Trần nhà hai tầng, trần nhà cấp 2 thường được làm rộng hơn 20cm, nếu chiều cao trần rất cao, bạn cũng có thể tăng độ dày của mỗi tầng";
    }

}
