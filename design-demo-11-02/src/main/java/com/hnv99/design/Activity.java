package com.hnv99.design;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Activity {

    private Long id;        // ID hoạt động
    private String name;    // Tên hoạt động
    private String desc;    // Mô tả hoạt động
    private Date startTime; // Thời gian bắt đầu
    private Date stopTime;  // Thời gian kết thúc
    private Stock stock;    // Tồn kho hoạt động
}
