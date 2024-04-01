package com.hnv99.design;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class LotteryResult {
    private String uId;    // ID người dùng
    private String msg;    // Thông tin quay số
    private Date dateTime; // Thời gian kinh doanh

}
