package com.hnv99.design;

import com.alibaba.fastjson.JSON;
import com.hnv99.design.mq.OrderMq;

public class OrderMqService {

    public void onMessage(String message) {

        OrderMq mq = JSON.parseObject(message, OrderMq.class);

        mq.getUid();
        mq.getOrderId();
        mq.getCreateOrderTime();

        // ... Xử lý nghiệp vụ của riêng bạn
    }

}

