package com.hnv99.design.cook.impl;

import com.hnv99.design.cook.ICook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JiangSuCook implements ICook {

    private Logger logger = LoggerFactory.getLogger(ICook.class);

    public void doCooking() {
        logger.info("Đầu bếp phong cách Giang Tô, nấu món Giang Tô, là một trong những dòng ẩm thực cung đình lớn nhất, được yêu thích nhất trong các tiệc quốc gia từ xưa đến nay.");
    }

}
