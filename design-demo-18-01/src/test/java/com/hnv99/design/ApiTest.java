package com.hnv99.design;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test() {
        MinibusTargetService minibusTargetService = new MinibusTargetService();
        String result = minibusTargetService.lottery("2765789109876");
        logger.info("Kết quả kiểm tra: {}", result);
    }

}
