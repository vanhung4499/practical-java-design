package com.hnv99.design.channel;

import com.hnv99.design.mode.IPayMode;

import java.math.BigDecimal;

public class WxPay extends Pay {

    public WxPay(IPayMode payMode) {
        super(payMode);
    }

    public String transfer(String uId, String tradeId, BigDecimal amount) {
        logger.info("Bắt đầu chuyển khoản qua kênh WeChat. uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
        boolean security = payMode.security(uId);
        logger.info("Kiểm tra bảo mật kênh WeChat. uId：{} tradeId：{} security：{}", uId, tradeId, security);
        if (!security) {
            logger.info("Chuyển khoản qua kênh WeChat bị chặn. uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
            return "0001";
        }
        logger.info("Chuyển khoản qua kênh WeChat thành công. uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
        return "0000";
    }

}

