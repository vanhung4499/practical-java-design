package com.hnv99.design;

import com.hnv99.design.util.RedisUtils;

public class ActivityController {

    private RedisUtils redisUtils = new RedisUtils();

    public Activity queryActivityInfo(Long id) {
        Activity activity = ActivityFactory.getActivity(id);
        // Giả lập việc lấy thông tin biến đổi tồn kho từ Redis
        Stock stock = new Stock(1000, redisUtils.getStockUsed());
        activity.setStock(stock);
        return activity;
    }

}
