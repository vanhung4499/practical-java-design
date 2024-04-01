package com.hnv99.design.impl;

import com.alibaba.fastjson.JSON;
import com.hnv99.design.HttpClient;
import com.hnv99.design.NetMall;
import sun.misc.BASE64Encoder;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JDNetMall extends NetMall {

    public JDNetMall(String uId, String uPwd) {
        super(uId, uPwd);
    }

    public Boolean login(String uId, String uPwd) {
        logger.info("Mô phỏng đăng nhập người dùng JD uId：{} uPwd：{}", uId, uPwd);
        return true;
    }

    public Map<String, String> reptile(String skuUrl) {
        String str = HttpClient.doGet(skuUrl);
        Pattern p9 = Pattern.compile("(?<=title\\>).*(?=</title)");
        Matcher m9 = p9.matcher(str);
        Map<String, String> map = new ConcurrentHashMap<String, String>();
        if (m9.find()) {
            map.put("name", m9.group());
        }
        map.put("price", "5999.00");
        logger.info("Mô phỏng phân tích dữ liệu của mặt hàng trên JD：{} | {} đồng {}", map.get("name"), map.get("price"), skuUrl);
        return map;
    }

    public String createBase64(Map<String, String> goodsInfo) {
        BASE64Encoder encoder = new BASE64Encoder();
        logger.info("Mô phỏng tạo ảnh base64 cho mặt hàng trên JD");
        return encoder.encode(JSON.toJSONString(goodsInfo).getBytes());
    }

}
