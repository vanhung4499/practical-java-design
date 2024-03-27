package com.hnv99.design.tile;

import com.hnv99.design.Matter;

import java.math.BigDecimal;

/**
 * Gạch
 * Thương hiệu: Prime
 */
public class PrimeTile implements Matter {
    public String scene() {
        return "Gạch";
    }

    public String brand() {
        return "Prime";
    }

    public String model() {
        return "Mặc định";
    }

    public BigDecimal price() {
        return new BigDecimal(102);
    }

    public String desc() {
        return "Prime là một thương hiệu gạch hàng đầu tại châu Á, với hơn 130 năm kinh nghiệm trong ngành công nghiệp gạch.";
    }
}
