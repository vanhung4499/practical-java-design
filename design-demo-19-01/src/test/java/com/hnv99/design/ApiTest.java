package com.hnv99.design;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiTest {
    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test() {
        // Khởi tạo dữ liệu
        String activityId = "100001";
        ActivityService.init(activityId, Status.Editing);

        ActivityExecStatusController activityExecStatusController = new ActivityExecStatusController();
        Result resultRefuse = activityExecStatusController.execStatus(activityId, Status.Editing, Status.Refuse);
        logger.info("Kết quả kiểm tra (Từ Chỉnh sửa đến Từ chối kiểm tra): {}", JSON.toJSONString(resultRefuse));

        Result resultCheck = activityExecStatusController.execStatus(activityId, Status.Editing, Status.Check);
        logger.info("Kết quả kiểm tra (Từ Chỉnh sửa đến Gửi kiểm tra): {}", JSON.toJSONString(resultCheck));
    }
}
