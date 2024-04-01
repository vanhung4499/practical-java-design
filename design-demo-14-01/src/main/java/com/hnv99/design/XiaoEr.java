package com.hnv99.design;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class XiaoEr {

    private Logger logger = LoggerFactory.getLogger(XiaoEr.class);

    private Map<Integer, String> cuisineMap = new ConcurrentHashMap<>();

    public void order(int cuisine) {
        // Quảng Đông (món ngon Quảng Đông)
        if (1 == cuisine) {
            cuisineMap.put(1, "Đầu bếp Quảng Đông, nấu món Lục Thái, là loại món ăn lớn nhất của cung đình, dựa trên hương vị cung đình");
        }

        // Giang Tô (món ngon Tô)
        if (2 == cuisine) {
            cuisineMap.put(2, "Đầu bếp Giang Tô, nấu món Tô, là loại món ăn lớn nhì của cung đình, được yêu thích nhất trong các bữa tiệc quốc gia từ xưa đến nay.");
        }

        // Sơn Đông (món ngon Lục)
        if (3 == cuisine) {
            cuisineMap.put(3, "Đầu bếp Sơn Đông, nấu món Lục Thái, là loại món ăn lớn nhất của cung đình, dựa trên hương vị cung đình.");
        }

        // Tứ Xuyên (món ngon Truân)
        if (4 == cuisine) {
            cuisineMap.put(4, "Đầu bếp Tứ Xuyên, nấu món Truân, là loại món ăn đặc trưng nhất của Trung Quốc, cũng là loại món ăn lớn nhất của dân gian.");
        }

    }

    public void placeOrder() {
        logger.info("Thực đơn: {}", JSON.toJSONString(cuisineMap));
    }

}
