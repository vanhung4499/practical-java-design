package com.hnv99.design.coat;

import com.hnv99.design.Matter;

import java.math.BigDecimal;

/**
 * Sơn
 * Thương hiệu; Dulux
 */
public class DuluxCoat implements Matter {

    public String scene() {
        return "Sơn";
    }

    public String brand() {
        return "Dulux";
    }

    public String model() {
        return "Thế hệ thứ hai";
    }

    public BigDecimal price() {
        return new BigDecimal(719);
    }

    public String desc() {
        return "Dulux là một thương hiệu sơn nổi tiếng thuộc sở hữu của tập đoàn AkzoNobel, sản phẩm được bán chạy ở hơn 100 quốc gia trên thế giới, mỗi năm có khoảng 50 triệu hộ gia đình sử dụng sơn Dulux.";
    }

}
