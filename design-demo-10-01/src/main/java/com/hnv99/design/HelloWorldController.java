package com.hnv99.design;

import com.hnv99.design.domain.UserInfo;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

public class HelloWorldController {

    public UserInfo queryUserInfo(@RequestParam String userId) {

        // Xây dựng whitelist
        List<String> userList = new ArrayList<String>();
        userList.add("1001");
        userList.add("aaaa");
        userList.add("ccc");
        if (!userList.contains(userId)) {
            return new UserInfo("1111", "Người dùng không nằm trong whitelist và bị chặn!");
        }

        return new UserInfo("Error:" + userId, 19, "Thu Duc, HCMC, Vietnam");
    }

}
