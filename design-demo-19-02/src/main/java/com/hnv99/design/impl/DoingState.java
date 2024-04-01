package com.hnv99.design.impl;

import com.hnv99.design.ActivityService;
import com.hnv99.design.Result;
import com.hnv99.design.State;
import com.hnv99.design.Status;

public class DoingState extends State {

    public Result arraignment(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "Hoạt động không thể gửi đề xuất khi đang trong quá trình thực hiện");
    }

    public Result checkPass(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "Hoạt động không thể duyệt khi đang trong quá trình thực hiện");
    }

    public Result checkRefuse(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "Hoạt động không thể từ chối khi đang trong quá trình thực hiện");
    }

    @Override
    public Result checkRevoke(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "Hoạt động không thể thu hồi kiểm tra khi đang trong quá trình thực hiện");
    }

    public Result close(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.Close);
        return new Result("0000", "Đóng hoạt động thành công");
    }

    public Result open(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "Hoạt động không thể mở khi đang trong quá trình thực hiện");
    }

    public Result doing(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "Không thể thực hiện lại khi đang trong quá trình thực hiện");
    }

}

