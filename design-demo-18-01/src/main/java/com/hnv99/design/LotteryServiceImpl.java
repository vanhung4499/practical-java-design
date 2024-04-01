package com.hnv99.design;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class LotteryServiceImpl implements LotteryService {

    private Logger logger = LoggerFactory.getLogger(LotteryServiceImpl.class);

    private MinibusTargetService minibusTargetService = new MinibusTargetService();

    public LotteryResult doDraw(String uId) {
        // Rút thăm
        String lottery = minibusTargetService.lottery(uId);
        // Gửi tin nhắn
        logger.info("Gửi tin nhắn thông báo cho người dùng {} (tin nhắn): {}", uId, lottery);
        // Gửi tin nhắn MQ
        logger.info("Ghi nhận kết quả rút thăm của người dùng {} (MQ): {}", uId, lottery);
        // Kết quả
        return new LotteryResult(uId, lottery, new Date());
    }

}
