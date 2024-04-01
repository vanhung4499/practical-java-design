package com.hnv99.design;

import com.hnv99.design.impl.JDNetMall;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiTest {

    public Logger logger = LoggerFactory.getLogger(ApiTest.class);

    /**
     * Kiểm tra liên kết
     * JD: https://item.jd.com/100008348542.html
     * Tmall: https://detail.tmall.com/item.htm
     * Dangdang: http://product.dangdang.com/1509704171.html
     */
    @Test
    public void test_NetMall() {
        NetMall netMall = new JDNetMall("1000001","*******");
        String base64 = netMall.generateGoodsPoster("https://item.jd.com/100008348542.html");
        logger.info("Kết quả kiểm tra: {}", base64);
    }

}

