package com.hnv99.design;

import org.junit.Test;

public class ApiTest {

    @Test
    public void test(){
        // Quảng Đông (món Quảng Đông), Giang Tô (món Tô), Sơn Đông (món Lỗ), Tứ Xuyên (món Sì Chuân)
        XiaoEr xiaoEr = new XiaoEr();
        xiaoEr.order(1);
        xiaoEr.order(2);
        xiaoEr.order(3);
        xiaoEr.order(4);

        // Đặt hàng
        xiaoEr.placeOrder();
    }

}

