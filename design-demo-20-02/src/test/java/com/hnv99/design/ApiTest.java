package com.hnv99.design;

import com.hnv99.design.impl.MJCouponDiscount;
import com.hnv99.design.impl.NYGCouponDiscount;
import com.hnv99.design.impl.ZJCouponDiscount;
import com.hnv99.design.impl.ZKCouponDiscount;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ApiTest {
    private static final Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void testZj() {
        // Trừ trực tiếp; 100-10, sản phẩm có giá 100 đồng
        Context<Double> context = new Context<Double>(new ZJCouponDiscount());
        BigDecimal discountAmount = context.discountAmount(10D, new BigDecimal(100));
        logger.info("Kết quả kiểm thử: Giá sau ưu đãi trực tiếp {}", discountAmount);
    }

    @Test
    public void testMj() {
        // Giảm 10 khi mua từ 100, sản phẩm có giá 100 đồng
        Context<Map<String, String>> context;
        context = new Context<Map<String, String>>(new MJCouponDiscount());
        Map<String, String> mapReq = new HashMap<>();
        mapReq.put("x", "100");
        mapReq.put("n", "10");
        BigDecimal discountAmount = context.discountAmount(mapReq, new BigDecimal(100));
        logger.info("Kết quả kiểm thử: Giá sau ưu đãi theo số lượng {}", discountAmount);
    }

    @Test
    public void testZk() {
        // Giảm giá 10%, sản phẩm có giá 100 đồng
        Context<Double> context = new Context<Double>(new ZKCouponDiscount());
        BigDecimal discountAmount = context.discountAmount(0.9D, new BigDecimal(100));
        logger.info("Kết quả kiểm thử: Giá sau ưu đãi giảm giá 9 {}", discountAmount);
    }

    @Test
    public void testNyg() {
        // Mua với giá N đồng; giảm 10%, sản phẩm có giá 100 đồng
        Context<Double> context = new Context<Double>(new NYGCouponDiscount());
        BigDecimal discountAmount = context.discountAmount(90D, new BigDecimal(100));
        logger.info("Kết quả kiểm thử: Giá sau ưu đãi mua với giá N đồng {}", discountAmount);
    }
}