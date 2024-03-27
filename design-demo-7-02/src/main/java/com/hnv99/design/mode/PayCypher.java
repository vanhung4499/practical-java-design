package com.hnv99.design.mode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PayCypher implements IPayMode {

    protected Logger logger = LoggerFactory.getLogger(PayCypher.class);

    public boolean security(String uId) {
        logger.info("Thanh toán bằng mật khẩu, kiểm tra bảo mật");
        return true;
    }

}
