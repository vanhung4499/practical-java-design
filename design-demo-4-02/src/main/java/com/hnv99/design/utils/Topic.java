package com.hnv99.design.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class Topic {

    private Map<String, String> option;  // Lựa chọn; A, B, C, D
    private String key;           // Đáp án; B
}