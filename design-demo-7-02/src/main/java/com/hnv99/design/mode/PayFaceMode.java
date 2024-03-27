package com.hnv99.design.mode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PayFaceMode implements IPayMode {

    protected Logger logger = LoggerFactory.getLogger(PayCypher.class);

    public boolean security(String uId) {
        logger.info("Thanh toán bằng khuôn mặt, kiểm tra nhận diện khuôn mặt");
        return true;
    }

}
