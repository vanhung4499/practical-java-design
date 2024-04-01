package com.hnv99.design.impl;

import com.hnv99.design.ActivityService;
import com.hnv99.design.Result;
import com.hnv99.design.State;
import com.hnv99.design.Status;

public class EditingState extends State {

    public Result arraignment(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.Check);
        return new Result("0000", "Hoạt động đã được đề nghị thành công");
    }

    public Result checkPass(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "Không thể duyệt trong quá trình chỉnh sửa");
    }

    public Result checkRefuse(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "Không thể từ chối trong quá trình chỉnh sửa");
    }

    @Override
    public Result checkRevoke(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "Không thể thu hồi kiểm tra trong quá trình chỉnh sửa");
    }

    public Result close(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.Close);
        return new Result("0000", "Hoạt động đã đóng thành công");
    }

    public Result open(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "Không thể mở hoạt động khi không được đóng");
    }

    public Result doing(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "Hoạt động không thể thực hiện trong quá trình chỉnh sửa");
    }

}