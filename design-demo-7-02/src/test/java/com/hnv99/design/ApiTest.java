package com.hnv99.design;

import com.hnv99.design.channel.Pay;
import com.hnv99.design.channel.WxPay;
import com.hnv99.design.channel.ZfbPay;
import com.hnv99.design.mode.PayFaceMode;
import com.hnv99.design.mode.PayFingerprintMode;
import org.junit.Test;

import java.math.BigDecimal;

public class ApiTest {
    @Test
    public void testPay() {

        System.out.println("\r\nMô phỏng kịch bản kiểm thử; thanh toán qua WeChat, bằng khuôn mặt.");
        Pay wxPay = new WxPay(new PayFaceMode());
        wxPay.transfer("weixin_1092033111", "100000109893", new BigDecimal(100));

        System.out.println("\r\nMô phỏng kịch bản kiểm thử; thanh toán qua Alipay, bằng dấu vân tay.");
        Pay zfbPay = new ZfbPay(new PayFingerprintMode());
        zfbPay.transfer("jlu19dlxo111","100000109894",new BigDecimal(100));

    }
}
