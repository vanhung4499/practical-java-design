package com.hnv99.design.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class POPOrderService {

    private Logger logger = LoggerFactory.getLogger(POPOrderService.class);

    public boolean isFirstOrder(String uId) {
        logger.info("Cửa hàng POP, truy vấn xem đơn hàng của người dùng có phải là đơn hàng đầu tiên không: {}", uId);        return true;
    }

}

