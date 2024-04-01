package com.hnv99.design.event.listener;

import com.hnv99.design.LotteryResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MQEventListener implements EventListener {

    private Logger logger = LoggerFactory.getLogger(MQEventListener.class);

    @Override
    public void doEvent(LotteryResult result) {
        logger.info("Ghi lại kết quả rút thăm của người dùng {} (MQ): {}", result.getUId(), result.getMsg());
    }

}