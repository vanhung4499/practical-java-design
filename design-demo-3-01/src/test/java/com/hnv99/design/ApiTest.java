package com.hnv99.design;

import org.junit.Test;

import java.math.BigDecimal;

public class ApiTest {

    @Test
    public void test_DecorationPackageController(){
        DecorationPackageController decoration = new DecorationPackageController();

        // Sang trọng kiểu Châu Âu
        System.out.println(decoration.getMatterList(new BigDecimal("132.52"),1));

        // Nông thôn nhẹ nhàng
        System.out.println(decoration.getMatterList(new BigDecimal("98.25"),2));

        // Hiện đại đơn giản
        System.out.println(decoration.getMatterList(new BigDecimal("85.43"),3));
    }

}
