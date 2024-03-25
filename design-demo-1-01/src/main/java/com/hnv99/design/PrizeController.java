package com.hnv99.design;


import com.alibaba.fastjson.JSON;
import com.hnv99.design.card.GarenaCardService;
import com.hnv99.design.coupon.CouponResult;
import com.hnv99.design.coupon.CouponService;
import com.hnv99.design.goods.DeliveryReq;
import com.hnv99.design.goods.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrizeController {

    private Logger logger = LoggerFactory.getLogger(PrizeController.class);

    public AwardRes awardToUser(AwardReq req) {
        String reqJson = JSON.toJSONString(req);
        AwardRes awardRes = null;
        try {
            logger.info("Bắt đầu phát thưởng cho {}。req:{}", req.getUId(), reqJson);
            // Dựa vào loại phần thưởng khác nhau [1 phiếu giảm giá, 2 hàng hóa thực tế, 3 thẻ đổi thưởng bên thứ ba (ví dụ  Garena)]
            if (req.getAwardType() == 1) {
                CouponService couponService = new CouponService();
                CouponResult couponResult = couponService.sendCoupon(req.getUId(), req.getAwardNumber(), req.getBizId());
                if ("0000".equals(couponResult.getCode())) {
                    awardRes = new AwardRes("0000", "Phát thành công");
                } else {
                    awardRes = new AwardRes("0001", couponResult.getInfo());
                }
            } else if (req.getAwardType() == 2) {
                GoodsService goodsService = new GoodsService();
                DeliveryReq deliverReq = new DeliveryReq();
                deliverReq.setUserName(queryUserName(req.getUId()));
                deliverReq.setUserPhone(queryUserPhoneNumber(req.getUId()));
                deliverReq.setSku(req.getAwardNumber());
                deliverReq.setOrderId(req.getBizId());
                deliverReq.setConsigneeUserName(req.getExtMap().get("consigneeUserName"));
                deliverReq.setConsigneeUserPhone(req.getExtMap().get("consigneeUserPhone"));
                deliverReq.setConsigneeUserAddress(req.getExtMap().get("consigneeUserAddress"));
                Boolean isSuccess = goodsService.deliverGoods(deliverReq);
                if (isSuccess) {
                    awardRes = new AwardRes("0000", "Phát thành công");
                } else {
                    awardRes = new AwardRes("0001", "Phát thất bại");
                }
            } else if (req.getAwardType() == 3) {
                String bindMobileNumber = queryUserPhoneNumber(req.getUId());
                GarenaCardService garenaCardService = new GarenaCardService();
                garenaCardService.grantToken(bindMobileNumber, req.getAwardNumber());
                awardRes = new AwardRes("0000", "Phát thành công");
            }
            logger.info("Hoàn tất việc phát thưởng cho {}。", req.getUId());
        } catch (Exception e) {
            logger.error("Phát thưởng thất bại {}。req:{}", req.getUId(), reqJson, e);
            awardRes = new AwardRes("0001", e.getMessage());
        }

        return awardRes;
    }

    private String queryUserName(String uId) {
        return "Hung Nguyen";
    }

    private String queryUserPhoneNumber(String uId) {
        return "012345678";
    }
}

