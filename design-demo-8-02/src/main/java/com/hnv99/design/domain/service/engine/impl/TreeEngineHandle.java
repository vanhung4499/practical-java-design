package com.hnv99.design.domain.service.engine.impl;

import com.hnv99.design.domain.model.aggregate.TreeRich;
import com.hnv99.design.domain.model.vo.EngineResult;
import com.hnv99.design.domain.model.vo.TreeNode;
import com.hnv99.design.domain.service.engine.EngineBase;

import java.util.Map;

public class TreeEngineHandle extends EngineBase {

    @Override
    public EngineResult process(Long treeId, String userId, TreeRich treeRich, Map<String, String> decisionMatter) {
        // Quy trình quyết định
        TreeNode treeNode = engineDecisionMaker(treeRich, treeId, userId, decisionMatter);
        // Kết quả quyết định
        return new EngineResult(userId, treeId, treeNode.getTreeNodeId(), treeNode.getNodeValue());
    }

}

