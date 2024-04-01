package com.hnv99.design.impl;

import com.hnv99.design.ActivityService;
import com.hnv99.design.Result;
import com.hnv99.design.State;
import com.hnv99.design.Status;

public class OpenState extends State {

    public Result arraignment(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "Không thể gửi đề xuất khi hoạt động đã được mở");
    }

    public Result checkPass(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "Không thể duyệt khi hoạt động đã được mở");
    }

    public Result checkRefuse(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "Không thể từ chối khi hoạt động đã được mở");
    }

    @Override
    public Result checkRevoke(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "Không thể thu hồi kiểm tra khi hoạt động đã được mở");
    }

    public Result close(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.Close);
        return new Result("0000", "Đóng hoạt động thành công");
    }

    public Result open(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "Không thể mở lại khi hoạt động đã được mở");
    }

    public Result doing(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.Doing);
        return new Result("0000", "Hoạt động được chuyển sang trạng thái thực hiện");
    }

}

