package com.hnv99.design.group;


import lombok.Data;

/**
 * Nhân viên
 */
@Data
public class Employee {

    private String uId;   // ID
    private String name;  // Tên
    private String desc;  // Ghi chú

    public Employee(String uId, String name) {
        this.uId = uId;
        this.name = name;
    }

    public Employee(String uId, String name, String desc) {
        this.uId = uId;
        this.name = name;
        this.desc = desc;
    }
}