package com.hnv99.design.channel;

import com.hnv99.design.mode.IPayMode;

import java.math.BigDecimal;

public class ZfbPay extends Pay {

    public ZfbPay(IPayMode payMode) {
        super(payMode);
    }

    public String transfer(String uId, String tradeId, BigDecimal amount) {
        logger.info("Bắt đầu chuyển khoản qua kênh Alipay. uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
        boolean security = payMode.security(uId);
        logger.info("Kiểm tra bảo mật kênh Alipay. uId：{} tradeId：{} security：{}", uId, tradeId, security);
        if (!security) {
            logger.info("Chuyển khoản qua kênh Alipay bị chặn. uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
            return "0001";
        }
        logger.info("Chuyển khoản qua kênh Alipay thành công. uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
        return "0000";
    }

}

