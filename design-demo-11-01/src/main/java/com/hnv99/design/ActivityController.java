package com.hnv99.design;

import java.util.Date;

public class ActivityController {

    public Activity queryActivityInfo(Long id) {
        // Giả lập việc lấy thông tin hoạt động từ giao diện ứng dụng doanh nghiệp thực tế
        Activity activity = new Activity();
        activity.setId(10001L);
        activity.setName("Đại tiệc Sách");
        activity.setDesc("Chương trình ưu đãi phiếu giảm giá sách tháng 2");
        activity.setStartTime(new Date());
        activity.setStopTime(new Date());
        activity.setStock(new Stock(1000, 1));
        return activity;
    }

}
