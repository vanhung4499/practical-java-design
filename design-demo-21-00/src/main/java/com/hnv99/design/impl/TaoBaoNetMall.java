package com.hnv99.design.impl;

import com.alibaba.fastjson.JSON;
import com.hnv99.design.HttpClient;
import com.hnv99.design.NetMall;
import sun.misc.BASE64Encoder;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaoBaoNetMall extends NetMall {

    public TaoBaoNetMall(String uId, String uPwd) {
        super(uId, uPwd);
    }

    @Override
    public Boolean login(String uId, String uPwd) {
        logger.info("Mô phỏng đăng nhập người dùng Taobao uId：{} uPwd：{}", uId, uPwd);
        return true;
    }

    @Override
    public Map<String, String> reptile(String skuUrl) {
        String str = HttpClient.doGet(skuUrl);
        Pattern p9 = Pattern.compile("(?<=title\\>).*(?=</title)");
        Matcher m9 = p9.matcher(str);
        Map<String, String> map = new ConcurrentHashMap<String, String>();
        if (m9.find()) {
            map.put("name", m9.group());
        }
        map.put("price", "4799.00");
        logger.info("Mô phỏng phân tích dữ liệu sản phẩm Taobao：{} | {} đồng {}", map.get("name"), map.get("price"), skuUrl);
        return map;
    }

    @Override
    public String createBase64(Map<String, String> goodsInfo) {
        BASE64Encoder encoder = new BASE64Encoder();
        logger.info("Mô phỏng tạo biển quảng cáo sản phẩm Taobao base64");
        return encoder.encode(JSON.toJSONString(goodsInfo).getBytes());
    }

}