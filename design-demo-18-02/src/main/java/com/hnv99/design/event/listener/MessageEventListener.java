package com.hnv99.design.event.listener;

import com.hnv99.design.LotteryResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageEventListener implements EventListener {

    private Logger logger = LoggerFactory.getLogger(MessageEventListener.class);

    @Override
    public void doEvent(LotteryResult result) {
        logger.info("Gửi tin nhắn thông báo (Tin nhắn) đến người dùng {}: {}", result.getUId(), result.getMsg());
    }

}