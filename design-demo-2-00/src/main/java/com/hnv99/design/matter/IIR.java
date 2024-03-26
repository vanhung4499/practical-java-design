package com.hnv99.design.matter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class IIR {

    private Logger logger = LoggerFactory.getLogger(IIR.class);

    private Map<String, String> dataMap = new ConcurrentHashMap<>();

    public String get(String key) {
        logger.info("IIR lấy dữ liệu key：{}", key);
        return dataMap.get(key);
    }

    public void set(String key, String value) {
        logger.info("IIR ghi dữ liệu key：{} val：{}", key, value);
        dataMap.put(key, value);
    }

    public void setExpire(String key, String value, long timeout, TimeUnit timeUnit) {
        logger.info("IIR ghi dữ liệu key：{} val：{} timeout：{} timeUnit：{}", key, value, timeout, timeUnit.toString());
        dataMap.put(key, value);
    }

    public void del(String key) {
        logger.info("IIR xóa dữ liệu key：{}", key);
        dataMap.remove(key);
    }

}