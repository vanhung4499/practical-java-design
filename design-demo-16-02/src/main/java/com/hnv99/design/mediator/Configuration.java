package com.hnv99.design.mediator;

import lombok.Setter;

import java.sql.Connection;
import java.util.Map;

@Setter
public class Configuration {

    protected Connection connection;
    protected Map<String, String> dataSource;
    protected Map<String, XNode> mapperElement;
}
