package com.hnv99.design;

import java.math.BigDecimal;

/**
 * Vật liệu trang trí
 */
public interface Matter {

    /**
     * Bối cảnh; Sàn nhà, Gạch lát sàn, Sơn, Trần nhà
     */
    String scene();

    /**
     * Thương hiệu
     */
    String brand();

    /**
     * Mô hình
     */
    String model();

    /**
     * Giá báo giá mỗi mét vuông
     */
    BigDecimal price();

    /**
     * Mô tả
     */
    String desc();

}
