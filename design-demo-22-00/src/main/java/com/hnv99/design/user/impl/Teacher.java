package com.hnv99.design.user.impl;

import com.hnv99.design.user.User;
import com.hnv99.design.visitor.Visitor;

import java.math.BigDecimal;

public class Teacher extends User {

    public Teacher(String name, String identity, String clazz) {
        super(name, identity, clazz);
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    // Tỷ lệ chuyển cấp
    public double entranceRatio() {
        return BigDecimal.valueOf(Math.random() * 100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

}
