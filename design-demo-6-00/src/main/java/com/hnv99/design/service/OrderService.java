package com.hnv99.design.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderService {
    private Logger logger = LoggerFactory.getLogger(POPOrderService.class);

    public long queryUserOrderCount(String userId){
        logger.info("Cửa hàng tự kinh doanh, truy vấn xem số đơn hàng của người dùng có phải là đơn hàng đầu tiên không: {}", userId);        return 10L;
    }
}
