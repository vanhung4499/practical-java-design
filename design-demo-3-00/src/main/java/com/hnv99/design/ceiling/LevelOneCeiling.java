package com.hnv99.design.ceiling;

import com.hnv99.design.Matter;

import java.math.BigDecimal;

/**
 * Trần nhà
 * Thương hiệu: Công ty trang trí tự động
 * Mô hình: Trần nhà cấp 1
 */
public class LevelOneCeiling implements Matter {

    public String scene() {
        return "Trần nhà";
    }

    public String brand() {
        return "Công ty trang trí tự động";
    }

    public String model() {
        return "Trần nhà cấp 1";
    }

    public BigDecimal price() {
        return new BigDecimal(260);
    }

    public String desc() {
        return "Thiết kế chỉ có một tầng, chỉ có một tầng của trần nhà, thường là cách trần 120-150mm";
    }

}
