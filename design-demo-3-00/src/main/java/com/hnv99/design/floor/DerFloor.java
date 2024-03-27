package com.hnv99.design.floor;

import com.hnv99.design.Matter;

import java.math.BigDecimal;

/**
 * Sàn gỗ
 * Thương hiệu; Der
 */
public class DerFloor implements Matter {

    public String scene() {
        return "Sàn gỗ";
    }

    public String brand() {
        return "Der";
    }

    public String model() {
        return "A+";
    }

    public BigDecimal price() {
        return new BigDecimal(119);
    }

    public String desc() {
        return "Tập đoàn Der là một trong những nhà sản xuất sàn gỗ chuyên nghiệp hàng đầu thế giới, là nhà cung cấp sàn gỗ cho trang trí nội thất và công trình công cộng của Thế vận hội Olympic Bắc Kinh 2008.";
    }

}

