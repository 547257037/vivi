package com.tiantian.common;

import lombok.Data;

@Data
public class DataSourceModel {
    private  String databasesName;
    private String  datasourceUrl;
    private String datasourceUsername;
    private String  datasourcePassword;


    public DataSourceModel(String databasesName, String datasourceUrl, String datasourceUsername, String datasourcePassword) {
        this.databasesName = databasesName;
        this.datasourceUrl = datasourceUrl;
        this.datasourceUsername = datasourceUsername;
        this.datasourcePassword = datasourcePassword;
    }
}
