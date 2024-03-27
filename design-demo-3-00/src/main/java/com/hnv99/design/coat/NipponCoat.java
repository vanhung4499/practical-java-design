package com.hnv99.design.coat;

import com.hnv99.design.Matter;

import java.math.BigDecimal;

/**
 * Sơn
 * Thương hiệu: Nippon
 */
public class NipponCoat implements Matter {
    public String scene() {
        return "Sơn";
    }

    public String brand() {
        return "Nippon";
    }

    public String model() {
        return "Thế hệ thứ hai";
    }

    public BigDecimal price() {
        return new BigDecimal(650);
    }

    public String desc() {
        return "Nippon là một thương hiệu sơn nổi tiếng, là thương hiệu sơn hàng đầu tại châu Á, với hơn 130 năm kinh nghiệm trong ngành công nghiệp sơn.";
    }
}
