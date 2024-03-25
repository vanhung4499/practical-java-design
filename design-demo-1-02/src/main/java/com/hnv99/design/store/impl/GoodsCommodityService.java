package com.hnv99.design.store.impl;

import com.alibaba.fastjson.JSON;
import com.hnv99.design.goods.DeliveryReq;
import com.hnv99.design.goods.GoodsService;
import com.hnv99.design.store.ICommodity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class GoodsCommodityService implements ICommodity {

    private Logger logger = LoggerFactory.getLogger(GoodsCommodityService.class);

    private GoodsService goodsService = new GoodsService();

    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        DeliveryReq deliveryReq = new DeliveryReq();
        deliveryReq.setUserName(queryUserName(uId));
        deliveryReq.setUserPhone(queryUserPhoneNumber(uId));
        deliveryReq.setSku(commodityId);
        deliveryReq.setOrderId(bizId);
        deliveryReq.setConsigneeUserName(extMap.get("consigneeUserName"));
        deliveryReq.setConsigneeUserPhone(extMap.get("consigneeUserPhone"));
        deliveryReq.setConsigneeUserAddress(extMap.get("consigneeUserAddress"));

        Boolean isSuccess = goodsService.deliverGoods(deliveryReq);

        logger.info("Tham số yêu cầu[Phiếu giảm giá] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, JSON.toJSON(extMap));
        logger.info("Kết quả kiểm thử[Phiếu giảm giá]：{}", isSuccess);

        if (!isSuccess) throw new RuntimeException("Phát hàng hóa thất bại");
    }

    private String queryUserName(String uId) {
        return "Hung Nguyen";
    }

    private String queryUserPhoneNumber(String uId) {
        return "012345678";
    }

}

