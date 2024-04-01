package com.hnv99.design;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test() {

        Admin admin = new Admin();

        ConfigOriginator configOriginator = new ConfigOriginator();

        configOriginator.setConfigFile(new ConfigFile("1000001", "Nội dung cấu hình A=Haha", new Date(), "Tiểu Phúc Ca"));
        admin.append(configOriginator.saveMemento()); // Lưu cấu hình

        configOriginator.setConfigFile(new ConfigFile("1000002", "Nội dung cấu hình A=Hihi", new Date(), "Tiểu Phúc Ca"));
        admin.append(configOriginator.saveMemento()); // Lưu cấu hình

        configOriginator.setConfigFile(new ConfigFile("1000003", "Nội dung cấu hình A=Meme", new Date(), "Tiểu Phúc Ca"));
        admin.append(configOriginator.saveMemento()); // Lưu cấu hình

        configOriginator.setConfigFile(new ConfigFile("1000004", "Nội dung cấu hình A=Hehe", new Date(), "Tiểu Phúc Ca"));
        admin.append(configOriginator.saveMemento()); // Lưu cấu hình

        // Lịch sử cấu hình (quay lại)
        configOriginator.getMemento(admin.undo());
        logger.info("Lịch sử cấu hình (quay lại) undo: {}", JSON.toJSONString(configOriginator.getConfigFile()));

        // Lịch sử cấu hình (quay lại)
        configOriginator.getMemento(admin.undo());
        logger.info("Lịch sử cấu hình (quay lại) undo: {}", JSON.toJSONString(configOriginator.getConfigFile()));

        // Lịch sử cấu hình (tiến tới)
        configOriginator.getMemento(admin.redo());
        logger.info("Lịch sử cấu hình (tiến tới) redo: {}", JSON.toJSONString(configOriginator.getConfigFile()));

        // Lịch sử cấu hình (nhận)
        configOriginator.getMemento(admin.get("1000002"));
        logger.info("Lịch sử cấu hình (nhận) get: {}", JSON.toJSONString(configOriginator.getConfigFile()));

    }

}
