package com.hnv99.design;

import lombok.Data;

import java.util.Date;

@Data
public class ActivityInfo {
    private String activityId;    // ID hoạt động
    private String activityName;  // Tên hoạt động
    private Enum<Status> status;  // Trạng thái hoạt động
    private Date beginTime;       // Thời gian bắt đầu
    private Date endTime;         // Thời gian kết thúc
}
