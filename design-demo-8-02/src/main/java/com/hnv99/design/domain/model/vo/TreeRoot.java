package com.hnv99.design.domain.model.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * Thông tin nút gốc của cây
 */
@Setter
@Getter
public class TreeRoot {
    private Long treeId;         // ID cây quyết định
    private Long treeRootNodeId; // ID nút gốc của cây
    private String treeName;     // Tên cây quyết định
}
