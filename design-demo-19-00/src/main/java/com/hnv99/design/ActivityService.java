package com.hnv99.design;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ActivityService {

    private static Map<String, Enum<Status>> statusMap = new ConcurrentHashMap<>();

    public static void init(String activityId, Enum<Status> status) {
        // Mô phỏng truy vấn thông tin hoạt động
        ActivityInfo activityInfo = new ActivityInfo();
        activityInfo.setActivityId(activityId);
        activityInfo.setActivityName("Chương trình thưởng thức sáng sớm và học tập");
        activityInfo.setStatus(status);
        activityInfo.setBeginTime(new Date());
        activityInfo.setEndTime(new Date());
        statusMap.put(activityId, status);
    }

    /**
     * Truy vấn thông tin hoạt động
     *
     * @param activityId ID hoạt động
     * @return Kết quả truy vấn
     */
    public static ActivityInfo queryActivityInfo(String activityId) {
        // Mô phỏng truy vấn thông tin hoạt động
        ActivityInfo activityInfo = new ActivityInfo();
        activityInfo.setActivityId(activityId);
        activityInfo.setActivityName("Chương trình thưởng thức sáng sớm và học tập");
        activityInfo.setStatus(statusMap.get(activityId));
        activityInfo.setBeginTime(new Date());
        activityInfo.setEndTime(new Date());
        return activityInfo;
    }

    /**
     * Truy vấn trạng thái hoạt động
     *
     * @param activityId ID hoạt động
     * @return Kết quả truy vấn
     */
    public static Enum<Status> queryActivityStatus(String activityId) {
        return statusMap.get(activityId);
    }

    /**
     * Thực hiện thay đổi trạng thái
     *
     * @param activityId   ID hoạt động
     * @param beforeStatus Trạng thái trước khi thay đổi
     * @param afterStatus  Trạng thái sau khi thay đổi
     */
    public static synchronized void execStatus(String activityId, Enum<Status> beforeStatus, Enum<Status> afterStatus) {
        if (!beforeStatus.equals(statusMap.get(activityId))) return;
        statusMap.put(activityId, afterStatus);
    }

}

