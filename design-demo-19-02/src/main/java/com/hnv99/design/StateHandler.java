package com.hnv99.design;

import com.hnv99.design.impl.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StateHandler {

    private Map<Enum<Status>, State> stateMap = new ConcurrentHashMap<Enum<Status>, State>();

    public StateHandler() {
        stateMap.put(Status.Check, new CheckState());     // Đang chờ xem xét
        stateMap.put(Status.Close, new CloseState());     // Đã đóng
        stateMap.put(Status.Doing, new DoingState());     // Đang thực hiện
        stateMap.put(Status.Editing, new EditingState()); // Đang chỉnh sửa
        stateMap.put(Status.Open, new OpenState());       // Đã mở
        stateMap.put(Status.Pass, new PassState());       // Đã phê duyệt
        stateMap.put(Status.Refuse, new RefuseState());   // Đã từ chối
    }

    public Result arraignment(String activityId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).arraignment(activityId, currentStatus);
    }

    public Result checkPass(String activityId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).checkPass(activityId, currentStatus);
    }

    public Result checkRefuse(String activityId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).checkRefuse(activityId, currentStatus);
    }

    public Result checkRevoke(String activityId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).checkRevoke(activityId, currentStatus);
    }

    public Result close(String activityId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).close(activityId, currentStatus);
    }

    public Result open(String activityId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).open(activityId, currentStatus);
    }

    public Result doing(String activityId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).doing(activityId, currentStatus);
    }

}

