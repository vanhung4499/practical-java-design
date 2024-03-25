package com.hnv99.design;

import com.alibaba.fastjson.JSON;
import org.slf4j.LoggerFactory;
import org.junit.Test;
import org.slf4j.Logger;

import java.util.HashMap;

public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_awardToUser() {
        PrizeController prizeController = new PrizeController();

        System.out.println("\r\nKiểm tra phát phiếu giảm giá\r\n");
        // Kiểm tra phát phiếu giảm giá
        AwardReq req01 = new AwardReq();
        req01.setUId("10001");
        req01.setAwardType(1);
        req01.setAwardNumber("EGM1023938910232121323432");
        req01.setBizId("791098764902132");
        AwardRes awardRes01 = prizeController.awardToUser(req01);

        logger.info("Tham số yêu cầu: {}", JSON.toJSON(req01));
        logger.info("Kết quả kiểm tra: {}", JSON.toJSON(awardRes01));

        System.out.println("\r\nKiểm tra việc giao dịch hàng hoá thực\r\n");
        // Kiểm tra giao dịch hàng hoá thực
        AwardReq req02 = new AwardReq();
        req02.setUId("10001");
        req02.setAwardType(2);
        req02.setAwardNumber("9820198721311");
        req02.setBizId("1023000020112221113");
        req02.setExtMap(new HashMap<String, String>() {{
            put("consigneeUserName", "Hung Nguyen");
            put("consigneeUserPhone", "012345678");
            put("consigneeUserAddress", "Thu Duc, HCMC");
        }});

        AwardRes awardRes02 = prizeController.awardToUser(req02);
        logger.info("Tham số yêu cầu: {}", JSON.toJSON(req02));
        logger.info("Kết quả kiểm tra: {}", JSON.toJSON(awardRes02));

        System.out.println("\r\nThẻ đổi thưởng bên thứ ba (Garena)\r\n");
        AwardReq req03 = new AwardReq();
        req03.setUId("10001");
        req03.setAwardType(3);
        req03.setAwardNumber("AQY1xjkUodl8LO975GdfrYUio");

        AwardRes awardRes03 = prizeController.awardToUser(req03);
        logger.info("Tham số yêu cầu: {}", JSON.toJSON(req03));
        logger.info("Kết quả kiểm tra: {}", JSON.toJSON(awardRes03));

    }
}
