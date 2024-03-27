package com.hnv99.design;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Câu hỏi và câu trả lời
 */
@Data
@AllArgsConstructor
public class AnswerQuestion implements Cloneable {

    private String name;  // Câu hỏi
    private String key;   // Câu trả lời
}
