package com.hnv99.design;

import java.util.Date;

public class LotteryServiceImpl extends LotteryService {

    private MinibusTargetService minibusTargetService = new MinibusTargetService();

    @Override
    protected LotteryResult doDraw(String uId) {
        // Trực tiếp ra số
        String lottery = minibusTargetService.lottery(uId);
        // Trả về kết quả
        return new LotteryResult(uId, lottery, new Date());
    }

}
