package com.hnv99.design.user;

import com.hnv99.design.visitor.Visitor;

// Thông tin người dùng cơ bản
public abstract class User {

    public String name;      // Tên
    public String identity;  // Danh tính; Lớp nâng cao, lớp thông thường | Giáo viên siêu cấp, giáo viên thông thường, giáo viên thực tập
    public String clazz;     // Lớp

    public User(String name, String identity, String clazz) {
        this.name = name;
        this.identity = identity;
        this.clazz = clazz;
    }

    // Phương thức truy cập cốt lõi
    public abstract void accept(Visitor visitor);

}
