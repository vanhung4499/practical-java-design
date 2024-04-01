package com.hnv99.design;

import com.hnv99.design.cook.impl.GuangDongCook;
import com.hnv99.design.cook.impl.JiangSuCook;
import com.hnv99.design.cook.impl.ShanDongCook;
import com.hnv99.design.cook.impl.SiChuanCook;
import com.hnv99.design.cuisine.ICuisine;
import com.hnv99.design.cuisine.impl.GuangDoneCuisine;
import com.hnv99.design.cuisine.impl.JiangSuCuisine;
import com.hnv99.design.cuisine.impl.ShanDongCuisine;
import com.hnv99.design.cuisine.impl.SiChuanCuisine;
import org.junit.Test;

public class ApiTest {
    @Test
    public void test(){

        // Các món ăn + Đầu bếp; Quảng Đông (Món Quảng Đông), Giang Tây (Món Giang Tây), Sơn Đông (Món Sơn Đông), Tứ Xuyên (Món Tứ Xuyên)
        ICuisine guangDoneCuisine = new GuangDoneCuisine(new GuangDongCook());
        JiangSuCuisine jiangSuCuisine = new JiangSuCuisine(new JiangSuCook());
        ShanDongCuisine shanDongCuisine = new ShanDongCuisine(new ShanDongCook());
        SiChuanCuisine siChuanCuisine = new SiChuanCuisine(new SiChuanCook());

        // Đặt hàng
        XiaoEr xiaoEr = new XiaoEr();
        xiaoEr.order(guangDoneCuisine);
        xiaoEr.order(jiangSuCuisine);
        xiaoEr.order(shanDongCuisine);
        xiaoEr.order(siChuanCuisine);

        // Đặt hàng
        xiaoEr.placeOrder();
    }

}
