package com.hnv99.design;

import com.alibaba.fastjson.JSON;
import com.hnv99.design.domain.model.aggregate.TreeRich;
import com.hnv99.design.domain.model.vo.EngineResult;
import com.hnv99.design.domain.model.vo.TreeNode;
import com.hnv99.design.domain.model.vo.TreeNodeLink;
import com.hnv99.design.domain.model.vo.TreeRoot;
import com.hnv99.design.domain.service.engine.IEngine;
import com.hnv99.design.domain.service.engine.impl.TreeEngineHandle;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiTest {

    private final Logger logger = LoggerFactory.getLogger(ApiTest.class);

    private TreeRich treeRich;

    @Before
    public void init() {

        // Node: 1
        TreeNode treeNode_01 = new TreeNode();
        treeNode_01.setTreeId(10001L);
        treeNode_01.setTreeNodeId(1L);
        treeNode_01.setNodeType(1);
        treeNode_01.setNodeValue(null);
        treeNode_01.setRuleKey("userGender");
        treeNode_01.setRuleDesc("Giới tính người dùng [Nam / Nữ]");

        // Link: 1->11
        TreeNodeLink treeNodeLink_11 = new TreeNodeLink();
        treeNodeLink_11.setNodeIdFrom(1L);
        treeNodeLink_11.setNodeIdTo(11L);
        treeNodeLink_11.setRuleLimitType(1);
        treeNodeLink_11.setRuleLimitValue("man");

        // Link: 1->12
        TreeNodeLink treeNodeLink_12 = new TreeNodeLink();
        treeNodeLink_12.setNodeIdFrom(1L);
        treeNodeLink_12.setNodeIdTo(12L);
        treeNodeLink_12.setRuleLimitType(1);
        treeNodeLink_12.setRuleLimitValue("woman");

        List<TreeNodeLink> treeNodeLinkList_1 = new ArrayList<>();
        treeNodeLinkList_1.add(treeNodeLink_11);
        treeNodeLinkList_1.add(treeNodeLink_12);

        treeNode_01.setTreeNodeLinkList(treeNodeLinkList_1);

        // Node: 11
        TreeNode treeNode_11 = new TreeNode();
        treeNode_11.setTreeId(10001L);
        treeNode_11.setTreeNodeId(11L);
        treeNode_11.setNodeType(1);
        treeNode_11.setNodeValue(null);
        treeNode_11.setRuleKey("userAge");
        treeNode_11.setRuleDesc("Tuổi của người dùng");

        // Link: 11->111
        TreeNodeLink treeNodeLink_111 = new TreeNodeLink();
        treeNodeLink_111.setNodeIdFrom(11L);
        treeNodeLink_111.setNodeIdTo(111L);
        treeNodeLink_111.setRuleLimitType(3);
        treeNodeLink_111.setRuleLimitValue("25");

        // Link: 11->112
        TreeNodeLink treeNodeLink_112 = new TreeNodeLink();
        treeNodeLink_112.setNodeIdFrom(11L);
        treeNodeLink_112.setNodeIdTo(112L);
        treeNodeLink_112.setRuleLimitType(4);
        treeNodeLink_112.setRuleLimitValue("25");

        List<TreeNodeLink> treeNodeLinkList_11 = new ArrayList<>();
        treeNodeLinkList_11.add(treeNodeLink_111);
        treeNodeLinkList_11.add(treeNodeLink_112);

        treeNode_11.setTreeNodeLinkList(treeNodeLinkList_11);

        // Node: 12
        TreeNode treeNode_12 = new TreeNode();
        treeNode_12.setTreeId(10001L);
        treeNode_12.setTreeNodeId(12L);
        treeNode_12.setNodeType(1);
        treeNode_12.setNodeValue(null);
        treeNode_12.setRuleKey("userAge");
        treeNode_12.setRuleDesc("Tuổi của người dùng");

        // Link: 12->121
        TreeNodeLink treeNodeLink_121 = new TreeNodeLink();
        treeNodeLink_121.setNodeIdFrom(12L);
        treeNodeLink_121.setNodeIdTo(121L);
        treeNodeLink_121.setRuleLimitType(3);
        treeNodeLink_121.setRuleLimitValue("25");

        // Link: 12->122
        TreeNodeLink treeNodeLink_122 = new TreeNodeLink();
        treeNodeLink_122.setNodeIdFrom(12L);
        treeNodeLink_122.setNodeIdTo(122L);
        treeNodeLink_122.setRuleLimitType(4);
        treeNodeLink_122.setRuleLimitValue("25");

        List<TreeNodeLink> treeNodeLinkList_12 = new ArrayList<>();
        treeNodeLinkList_12.add(treeNodeLink_121);
        treeNodeLinkList_12.add(treeNodeLink_122);

        treeNode_12.setTreeNodeLinkList(treeNodeLinkList_12);

        // Node: 111
        TreeNode treeNode_111 = new TreeNode();
        treeNode_111.setTreeId(10001L);
        treeNode_111.setTreeNodeId(111L);
        treeNode_111.setNodeType(2);
        treeNode_111.setNodeValue("Kết quả A");

        // Node: 112
        TreeNode treeNode_112 = new TreeNode();
        treeNode_112.setTreeId(10001L);
        treeNode_112.setTreeNodeId(112L);
        treeNode_112.setNodeType(2);
        treeNode_112.setNodeValue("Kết quả B");

        TreeNode treeNode_121 = new TreeNode();
        treeNode_121.setTreeId(10001L);
        treeNode_121.setTreeNodeId(121L);
        treeNode_121.setNodeType(2);
        treeNode_121.setNodeValue("Kết quả C");

        // Node: 122
        TreeNode treeNode_122 = new TreeNode();
        treeNode_122.setTreeId(10001L);
        treeNode_122.setTreeNodeId(122L);
        treeNode_122.setNodeType(2);
        treeNode_122.setNodeValue("Kết quả D");

        // Tree root
        TreeRoot treeRoot = new TreeRoot();
        treeRoot.setTreeId(10001L);
        treeRoot.setTreeRootNodeId(1L);
        treeRoot.setTreeName("Cây quyết định");

        Map<Long, TreeNode> treeNodeMap = new HashMap<>();
        treeNodeMap.put(1L, treeNode_01);
        treeNodeMap.put(11L, treeNode_11);
        treeNodeMap.put(12L, treeNode_12);
        treeNodeMap.put(111L, treeNode_111);
        treeNodeMap.put(112L, treeNode_112);
        treeNodeMap.put(121L, treeNode_121);
        treeNodeMap.put(122L, treeNode_122);

        treeRich = new TreeRich(treeRoot, treeNodeMap);

    }

    @Test
    public void testTree() {
        logger.info("Thông tin kết cấu tổ hợp của cây quyết định:\r\n" + JSON.toJSONString(treeRich));

        IEngine treeEngineHandle = new TreeEngineHandle();

        Map<String, String> decisionMatter = new HashMap<>();
        decisionMatter.put("gender", "man");
        decisionMatter.put("age", "29");

        EngineResult result = treeEngineHandle.process(10001L, "Oli09pLkdjh", treeRich, decisionMatter);
        logger.info("Kết quả thử nghiệm: {}", JSON.toJSONString(result));

    }
}