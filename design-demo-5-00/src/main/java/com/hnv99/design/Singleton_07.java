package com.hnv99.design;

/**
 * Mẫu Singleton dưới dạng enum (An toàn đa luồng) được khuyến nghị bởi tác giả của Effective Java
 */
public enum Singleton_07 {

    INSTANCE;

    public void test(){
        System.out.println("Xin chào~");
    }

}
