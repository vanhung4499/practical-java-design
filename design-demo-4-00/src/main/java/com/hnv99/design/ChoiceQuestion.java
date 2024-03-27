package com.hnv99.design;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

/**
 * Câu hỏi lựa chọn
 */
@Data
@AllArgsConstructor
public class ChoiceQuestion {

    private String name;                 // Câu hỏi
    private Map<String, String> option;  // Lựa chọn; A, B, C, D
    private String key;                  // Đáp án; B
}

