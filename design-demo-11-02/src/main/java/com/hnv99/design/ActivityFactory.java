package com.hnv99.design;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ActivityFactory {

    static Map<Long, Activity> activityMap = new HashMap<>();

    public static Activity getActivity(Long id) {
        Activity activity = activityMap.get(id);
        if (null == activity) {
            // Giả lập việc lấy thông tin hoạt động từ ứng dụng kinh doanh thực tế từ API
            activity = new Activity();
            activity.setId(10001L);
            activity.setName("Sự kiện Sách vui vẻ");
            activity.setDesc("Chia sẻ mã giảm giá sách để khuyến khích chia sẻ sự kiện giảm giá sách lần thứ hai");
            activity.setStartTime(new Date());
            activity.setStopTime(new Date());
            activityMap.put(id, activity);
        }
        return activity;
    }

}