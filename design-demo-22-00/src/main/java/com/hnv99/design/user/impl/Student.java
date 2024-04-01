package com.hnv99.design.user.impl;

import com.hnv99.design.user.User;
import com.hnv99.design.visitor.Visitor;

public class Student extends User {

    public Student(String name, String identity, String clazz) {
        super(name, identity, clazz);
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    // Xếp hạng
    public int ranking() {
        return (int) (Math.random() * 100);
    }

}

