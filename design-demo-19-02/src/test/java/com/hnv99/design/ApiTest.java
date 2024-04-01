package com.hnv99.design;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiTest {
    private static final Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void testEditing2Arraignment() {
        String activityId = "100001";
        ActivityService.init(activityId, Status.Editing);
        StateHandler stateHandler = new StateHandler();
        Result result = stateHandler.arraignment(activityId, Status.Editing);
        logger.info("Kết quả kiểm thử (Chỉnh sửa sang Đề xuất): {}", JSON.toJSONString(result));
        logger.info("Thông tin hoạt động: {} Trạng thái: {}", JSON.toJSONString(ActivityService.queryActivityInfo(activityId)), JSON.toJSONString(ActivityService.queryActivityInfo(activityId).getStatus()));
    }

    @Test
    public void testEditing2Open() {
        String activityId = "100001";
        ActivityService.init(activityId, Status.Editing);
        StateHandler stateHandler = new StateHandler();
        Result result = stateHandler.open(activityId, Status.Editing);
        logger.info("Kết quả kiểm thử (Chỉnh sửa sang Mở): {}", JSON.toJSONString(result));
        logger.info("Thông tin hoạt động: {} Trạng thái: {}", JSON.toJSONString(ActivityService.queryActivityInfo(activityId)), JSON.toJSONString(ActivityService.queryActivityInfo(activityId).getStatus()));
    }

    @Test
    public void testRefuse2Doing() {
        String activityId = "100001";
        ActivityService.init(activityId, Status.Refuse);
        StateHandler stateHandler = new StateHandler();
        Result result = stateHandler.doing(activityId, Status.Refuse);
        logger.info("Kết quả kiểm thử (Từ từ chối sang Đang thực hiện): {}", JSON.toJSONString(result));
        logger.info("Thông tin hoạt động: {} Trạng thái: {}", JSON.toJSONString(ActivityService.queryActivityInfo(activityId)), JSON.toJSONString(ActivityService.queryActivityInfo(activityId).getStatus()));
    }

    @Test
    public void testRefuse2Revoke() {
        String activityId = "100001";
        ActivityService.init(activityId, Status.Refuse);
        StateHandler stateHandler = new StateHandler();
        Result result = stateHandler.checkRevoke(activityId, Status.Refuse);
        logger.info("Kết quả kiểm thử (Từ từ chối sang Thu hồi): {}", JSON.toJSONString(result));
        logger.info("Thông tin hoạt động: {} Trạng thái: {}", JSON.toJSONString(ActivityService.queryActivityInfo(activityId)), JSON.toJSONString(ActivityService.queryActivityInfo(activityId).getStatus()));
    }
}
