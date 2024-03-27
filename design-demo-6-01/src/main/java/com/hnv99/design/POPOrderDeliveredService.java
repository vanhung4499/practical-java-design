package com.hnv99.design;

import com.alibaba.fastjson.JSON;
import com.hnv99.design.mq.POPOrderDelivered;

public class POPOrderDeliveredService {
    public void onMessage(String message) {

        POPOrderDelivered mq = JSON.parseObject(message, POPOrderDelivered.class);

        mq.getUId();
        mq.getOrderId();
        mq.getOrderTime();

        // ... Xử lý nghiệp vụ của riêng bạn
    }
}
