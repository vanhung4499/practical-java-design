package com.hnv99.design.matter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class EGM {

    private Logger logger = LoggerFactory.getLogger(EGM.class);

    private Map<String, String> dataMap = new ConcurrentHashMap<>();

    public String gain(String key) {
        logger.info("EGM lấy dữ liệu key：{}", key);
        return dataMap.get(key);
    }

    public void set(String key, String value) {
        logger.info("EGM ghi dữ liệu key：{} val：{}", key, value);
        dataMap.put(key, value);
    }

    public void setEx(String key, String value, long timeout, TimeUnit timeUnit) {
        logger.info("EGM ghi dữ liệu key：{} val：{} timeout：{} timeUnit：{}", key, value, timeout, timeUnit.toString());
        dataMap.put(key, value);
    }

    public void delete(String key) {
        logger.info("EGM xóa dữ liệu key：{}", key);
        dataMap.remove(key);
    }

}
