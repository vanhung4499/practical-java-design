package com.hnv99.design;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Date;

public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void testAuthController() throws ParseException {
        AuthController authController = new AuthController();

        // Mô phỏng việc phê duyệt của người phụ trách cấp ba
        logger.info("Kết quả kiểm tra: {}", JSON.toJSONString(authController.doAuth("Hung", "1000998004813441", new Date())));
        logger.info("Kết quả kiểm tra: {}", "Mô phỏng việc phê duyệt của người phụ trách cấp ba, An");
        AuthService.auth("1000013", "1000998004813441");

        // Mô phỏng việc phê duyệt của người phụ trách cấp hai
        logger.info("Kết quả kiểm tra: {}", JSON.toJSONString(authController.doAuth("Hung", "1000998004813441", new Date())));
        logger.info("Kết quả kiểm tra: {}", "Mô phỏng việc phê duyệt của người phụ trách cấp hai, Binh");
        AuthService.auth("1000012", "1000998004813441");

        // Mô phỏng việc phê duyệt của người phụ trách cấp một
        logger.info("Kết quả kiểm tra: {}", JSON.toJSONString(authController.doAuth("Hung", "1000998004813441", new Date())));
        logger.info("Kết quả kiểm tra: {}", "Mô phỏng việc phê duyệt của người phụ trách cấp một, Thinh");
        AuthService.auth("1000011", "1000998004813441");

        logger.info("Kết quả kiểm tra: {}", "Phê duyệt hoàn thành");
    }

}

