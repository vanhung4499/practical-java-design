package com.hnv99.design.mediator;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class XNode {
    private String namespace;
    private String id;
    private String parameterType;
    private String resultType;
    private String sql;
    private Map<Integer, String> parameter;
}
