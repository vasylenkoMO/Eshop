package com.testEshop.model.entity;

/**
 * Created by vastl271nko on 06.09.16.
 */
public enum ClientProfileType {
    USER("USER"),
    DBA("DBA"),
    ADMIN("ADMIN");

    String clientProfileType;

    private ClientProfileType(String userProfileType){
        this.clientProfileType = userProfileType;
    }

    public String getUserProfileType(){
        return clientProfileType;
    }
}
