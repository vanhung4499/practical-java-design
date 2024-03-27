package com.hnv99.design.tile;

import com.hnv99.design.Matter;

import java.math.BigDecimal;

/**
 * Gạch lát
 * Thương hiệu: Marco Polo
 */
public class MarcoPoloTile implements Matter {

    public String scene() {
        return "Gạch lát";
    }

    public String brand() {
        return "Marco Polo";
    }

    public String model() {
        return "Mặc định";
    }

    public BigDecimal price() {
        return new BigDecimal(140);
    }

    public String desc() {
        return "Thương hiệu 'Marco Polo' được thành lập vào năm 1996 và là một trong những thương hiệu gạch lát hàng đầu ở Trung Quốc. Với phong cách 'Gạch lát cổ điển' độc đáo, thương hiệu này đã thu hút sự chú ý của thị trường và được biết đến với biệt danh 'Vị vua của Gạch lát cổ điển'.";
    }

}
