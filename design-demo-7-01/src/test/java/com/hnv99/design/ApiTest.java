package com.hnv99.design;

import org.junit.Test;

import java.math.BigDecimal;

public class ApiTest {

    @Test
    public void testPay() {
        PayController pay = new PayController();

        System.out.println("\r\nMô phỏng kịch bản kiểm thử; thanh toán qua WeChat, bằng khuôn mặt.");
        pay.doPay("weixin_1092033111", "100000109893", new BigDecimal(100), 1, 2);

        System.out.println("\r\nMô phỏng kịch bản kiểm thử; thanh toán qua Alipay, bằng dấu vân tay.");
        pay.doPay("jlu19dlxo111","100000109894",new BigDecimal(100), 2, 3);
    }

}

