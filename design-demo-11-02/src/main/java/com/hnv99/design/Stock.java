package com.hnv99.design;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Stock {

    private int total; // Tổng số tồn kho
    private int used;  // Số tồn kho đã sử dụng

}