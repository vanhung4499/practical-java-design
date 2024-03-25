package com.hnv99.design.goods;

import com.alibaba.fastjson.JSON;

/**
 * Mô phỏng dịch vụ hàng hóa thực
 */
public class GoodsService {
    /**
     * Phát thuởng hàng hóa thực
     * @param req yêu cầu giao hàng
     * @return true nếu giao hàng thành công, ngược lại trả về false
     */
    public Boolean deliverGoods(DeliveryReq req) {
        System.out.println("Mô phỏng việc giao hàng hàng hoá thực: " + JSON.toJSONString(req));
        return true;
    }
}
