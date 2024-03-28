package com.hnv99.design.domain.model.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Thông tin nút của cây quyết định
 */
@Setter
@Getter
public class TreeNode {
    private Long treeId;        // ID cây quyết định
    private Long treeNodeId;    // ID nút cây quyết định

    private Integer nodeType;   // Loại nút; 1 lá, 2 quả
    private String nodeValue;   // Giá trị nút [nodeType=2]; giá trị quả
    private String ruleKey;     // Khoá quết định
    private String ruleDesc;    // Mô tả quết định
    private List<TreeNodeLink> treeNodeLinkList; // Liên kết nút
}
