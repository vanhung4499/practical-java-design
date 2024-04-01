package com.hnv99.design;

import com.alibaba.fastjson.JSON;
import com.hnv99.design.cuisine.impl.Level1AuthLink;
import com.hnv99.design.cuisine.impl.Level2AuthLink;
import com.hnv99.design.cuisine.impl.Level3AuthLink;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Date;

public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void testAuthLink() throws ParseException {
        AuthLink authLink = new Level3AuthLink("1000013", "An")
                .appendNext(new Level2AuthLink("1000012", "Binh")
                        .appendNext(new Level1AuthLink("1000011", "Thinh")));

        logger.info("Kết quả kiểm tra: {}", JSON.toJSONString(authLink.doAuth("Hung", "1000998004813441", new Date())));

        // Mô phỏng việc phê duyệt của người phụ trách cấp ba
        AuthService.auth("1000013", "1000998004813441");
        logger.info("Kết quả kiểm tra: {}", "Mô phỏng việc phê duyệt của người phụ trách cấp ba, An");
        logger.info("Kết quả kiểm tra: {}", JSON.toJSONString(authLink.doAuth("Hung", "1000998004813441", new Date())));

        // Mô phỏng việc phê duyệt của người phụ trách cấp hai
        AuthService.auth("1000012", "1000998004813441");
        logger.info("Kết quả kiểm tra: {}", "Mô phỏng việc phê duyệt của người phụ trách cấp hai, Binh");
        logger.info("Kết quả kiểm tra: {}", JSON.toJSONString(authLink.doAuth("Hung", "1000998004813441", new Date())));

        // Mô phỏng việc phê duyệt của người phụ trách cấp một
        AuthService.auth("1000011", "1000998004813441");
        logger.info("Kết quả kiểm tra: {}", "Mô phỏng việc phê duyệt của người phụ trách cấp một, Thinh");
        logger.info("Kết quả kiểm tra: {}", JSON.toJSONString(authLink.doAuth("Hung", "1000998004813441", new Date())));

    }

}
