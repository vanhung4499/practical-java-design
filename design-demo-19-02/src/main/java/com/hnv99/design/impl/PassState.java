package com.hnv99.design.impl;

import com.hnv99.design.ActivityService;
import com.hnv99.design.Result;
import com.hnv99.design.State;
import com.hnv99.design.Status;

public class PassState extends State {

    public Result arraignment(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "Trạng thái đã duyệt không thể gửi đề xuất lại");
    }

    public Result checkPass(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "Trạng thái đã duyệt không thể duyệt lại");
    }

    public Result checkRefuse(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.Refuse);
        return new Result("0000", "Hoạt động đã từ chối kiểm tra");
    }

    @Override
    public Result checkRevoke(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "Không thể thu hồi đã được duyệt (có thể từ chối kiểm tra trước)");
    }

    public Result close(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.Close);
        return new Result("0000", "Hoạt động đã đóng sau khi được duyệt");
    }

    public Result open(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "Không thể mở khi hoạt động đã được duyệt");
    }

    public Result doing(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.Doing);
        return new Result("0000", "Hoạt động đã chuyển sang trạng thái thực hiện sau khi được duyệt");
    }

}
