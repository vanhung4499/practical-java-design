package com.hnv99.design.floor;

import com.hnv99.design.Matter;

import java.math.BigDecimal;

public class InovarFloor implements Matter {
    public String scene() {
        return "Sàn";
    }

    public String brand() {
        return "Inovar";
    }

    public String model() {
        return "Thế hệ thứ hai";
    }

    public BigDecimal price() {
        return new BigDecimal(318);
    }

    public String desc() {
        return "Inovar là một thương hiệu sàn nổi tiếng, là thương hiệu sàn hàng đầu tại châu Á, với hơn 130 năm kinh nghiệm trong ngành công nghiệp sàn.";
    }
}
