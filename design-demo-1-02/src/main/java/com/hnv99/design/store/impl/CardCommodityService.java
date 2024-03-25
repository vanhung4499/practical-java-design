package com.hnv99.design.store.impl;

import com.alibaba.fastjson.JSON;
import com.hnv99.design.card.GarenaCardService;
import com.hnv99.design.store.ICommodity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class CardCommodityService implements ICommodity {

    private Logger logger = LoggerFactory.getLogger(CardCommodityService.class);

    // Giả lập việc chèn
    private GarenaCardService garenaCardService = new GarenaCardService();

    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        String mobile = queryUserMobile(uId);
        garenaCardService.grantToken(mobile, bizId);
        logger.info("Tham số yêu cầu[Thẻ đổi thưởng Garena] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, JSON.toJSON(extMap));
        logger.info("Kết quả kiểm thử[Thẻ đổi thưởng Garena]：Thành công");
    }

    private String queryUserMobile(String uId) {
        return "012345678";
    }

}

