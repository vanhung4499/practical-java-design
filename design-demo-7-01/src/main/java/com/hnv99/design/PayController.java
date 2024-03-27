package com.hnv99.design;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class PayController {

    private Logger logger = LoggerFactory.getLogger(PayController.class);

    public boolean doPay(String uId, String tradeId, BigDecimal amount, int channelType, int modeType) {
        // Thanh toán qua WeChat
        if (1 == channelType) {
            logger.info("Bắt đầu thanh toán qua kênh WeChat. uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
            if (1 == modeType) {
                logger.info("Thanh toán bằng mật khẩu, kiểm tra an ninh môi trường");
            } else if (2 == modeType) {
                logger.info("Thanh toán bằng khuôn mặt, kiểm tra nhận diện khuôn mặt");
            } else if (3 == modeType) {
                logger.info("Thanh toán bằng dấu vân tay, kiểm tra thông tin dấu vân tay");
            }
        }
        // Thanh toán qua Alipay
        else if (2 == channelType) {
            logger.info("Bắt đầu thanh toán qua kênh Alipay. uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
            if (1 == modeType) {
                logger.info("Thanh toán bằng mật khẩu, kiểm tra an ninh môi trường");
            } else if (2 == modeType) {
                logger.info("Thanh toán bằng khuôn mặt, kiểm tra nhận diện khuôn mặt");
            } else if (3 == modeType) {
                logger.info("Thanh toán bằng dấu vân tay, kiểm tra thông tin dấu vân tay");
            }
        }
        return true;
    }

}

