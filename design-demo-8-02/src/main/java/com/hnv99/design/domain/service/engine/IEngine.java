package com.hnv99.design.domain.service.engine;

import com.hnv99.design.domain.model.aggregate.TreeRich;
import com.hnv99.design.domain.model.vo.EngineResult;

import java.util.Map;

public interface IEngine {

    EngineResult process(final Long treeId, final String userId, TreeRich treeRich, final Map<String, String> decisionMatter);

}
