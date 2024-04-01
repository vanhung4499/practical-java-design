package com.hnv99.design.cook.impl;

import com.hnv99.design.cook.ICook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShanDongCook implements ICook {

    private Logger logger = LoggerFactory.getLogger(ICook.class);

    public void doCooking() {
        logger.info("Đầu bếp phong cách Sơn Đông, nấu món Sơn Đông, là một trong những dòng ẩm thực cung đình lớn nhất, đặc sắc với phong cách nhà Khổng.");
    }

}
