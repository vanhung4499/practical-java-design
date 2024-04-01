package com.hnv99.design.web;

import com.hnv99.design.domain.UserInfo;
import com.hnv99.design.door.annotation.DoDoor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    @Value("${server.port}")
    private int port;

    /**
     * @DoDoor Annotation tùy chỉnh
     * key: Thuộc tính cần lấy giá trị từ tham số đầu vào, nếu là một đối tượng thì lấy giá trị từ đối tượng đó, nếu là một giá trị đơn thì sử dụng trực tiếp
     * returnJson: Giá trị trả về dự định khi bị chặn, là một đối tượng Json
     *
     * http://localhost:8080/api/queryUserInfo?userId=1001
     * http://localhost:8080/api/queryUserInfo?userId=hung
     */
    @DoDoor(key = "userId", returnJson = "{\"code\":\"1111\",\"info\":\"Người dùng không nằm trong whitelist, bị chặn truy cập!\"}")
    @GetMapping(path = "/api/queryUserInfo")
    public UserInfo queryUserInfo(@RequestParam String userId) {
        return new UserInfo("Error:" + userId, 19, "Thu Duc, HCMC, Vietnam");
    }

}