package com.hnv99.design.domain.model.aggregate;

import com.hnv99.design.domain.model.vo.TreeNode;
import com.hnv99.design.domain.model.vo.TreeRoot;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * Tổng hợp cây quết định
 */
@Getter
@Setter
@AllArgsConstructor
public class TreeRich {
    private TreeRoot treeRoot;                          // Thông tin gốc cây
    private Map<Long, TreeNode> treeNodeMap;            // ID nút cây -> Nút con
}
