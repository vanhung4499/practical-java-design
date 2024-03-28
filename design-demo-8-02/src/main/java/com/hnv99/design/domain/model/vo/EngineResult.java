package com.hnv99.design.domain.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Kết quả quyết định
 */
@Getter
@Setter
@AllArgsConstructor
public class EngineResult {
    private boolean isSuccess; // Kết quả thực thi
    private String userId;     // ID người dùng
    private Long treeId;       // ID cây quy tắc
    private Long nodeId;       // ID nút kết quả
    private String nodeValue;  // Giá trị nút kết quả

    public EngineResult(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public EngineResult(String userId, Long treeId, Long nodeId, String nodeValue) {
        this.isSuccess = true;
        this.userId = userId;
        this.treeId = treeId;
        this.nodeId = nodeId;
        this.nodeValue = nodeValue;
    }

}
