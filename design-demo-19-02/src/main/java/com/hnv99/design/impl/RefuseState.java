package com.hnv99.design.impl;

import com.hnv99.design.ActivityService;
import com.hnv99.design.Result;
import com.hnv99.design.State;
import com.hnv99.design.Status;

public class RefuseState extends State {

    public Result arraignment(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "Trạng thái đã được kiểm tra không thể gửi đề xuất lại");
    }

    public Result checkPass(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "Trạng thái đã được kiểm tra không thể kiểm tra lại");
    }

    public Result checkRefuse(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.Refuse);
        return new Result("0000", "Hoạt động đã bị từ chối kiểm tra không thể kiểm tra lại");
    }

    @Override
    public Result checkRevoke(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.Editing);
        return new Result("0000", "Thu hồi kiểm tra hoàn tất");
    }

    public Result close(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.Close);
        return new Result("0000", "Hoạt động kiểm tra đã đóng");
    }

    public Result open(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "Không thể mở hoạt động khi chưa đóng");
    }

    public Result doing(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "Không thể thực hiện hoạt động khi đã từ chối kiểm tra");
    }

}

