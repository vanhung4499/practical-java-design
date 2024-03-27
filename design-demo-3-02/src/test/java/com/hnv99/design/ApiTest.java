package com.hnv99.design;

import org.junit.Test;

public class ApiTest {

    @Test
    public void test_Builder(){
        Builder builder = new Builder();

        // Cao cấp Châu Âu
        System.out.println(builder.levelOne(132.52D).getDetail());

        // Nông thôn nhẹ nhàng
        System.out.println(builder.levelTwo(98.25D).getDetail());

        // Hiện đại đơn giản
        System.out.println(builder.levelThree(85.43D).getDetail());
    }

}
