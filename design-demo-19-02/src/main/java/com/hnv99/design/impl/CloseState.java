package com.hnv99.design.impl;

import com.hnv99.design.ActivityService;
import com.hnv99.design.Result;
import com.hnv99.design.State;
import com.hnv99.design.Status;

public class CloseState extends State {

    public Result arraignment(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "Hoạt động đã đóng không thể gửi đề xuất");
    }

    public Result checkPass(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "Hoạt động đã đóng không thể duyệt");
    }

    public Result checkRefuse(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "Hoạt động đã đóng không thể từ chối");
    }

    @Override
    public Result checkRevoke(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "Hoạt động đã đóng không thể thu hồi kiểm tra");
    }

    public Result close(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "Hoạt động đã đóng không thể đóng lại");
    }

    public Result open(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.Open);
        return new Result("0000", "Hoạt động đã mở");
    }

    public Result doing(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "Hoạt động đã đóng không thể thực hiện thay đổi trạng thái");
    }

}
