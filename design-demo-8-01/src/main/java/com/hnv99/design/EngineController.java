package com.hnv99.design;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EngineController {

    private Logger logger = LoggerFactory.getLogger(EngineController.class);

    public String process(final String userId, final String userSex, final int userAge) {

        logger.info("Sử dụng cách thực hiện if-else để xác định kết quả người dùng. userId：{} userSex：{} userAge：{}", userId, userSex, userAge);

        if ("man".equals(userSex)) {
            if (userAge < 25) {
                return "Kết quả A";
            }

            if (userAge >= 25) {
                return "Kết quả B";
            }
        }

        if ("woman".equals(userSex)) {
            if (userAge < 25) {
                return "Kết quả C";
            }

            if (userAge >= 25) {
                return "Kết quả D";
            }
        }

        return null;

    }

}

