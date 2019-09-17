package com.roma.mainproject.serviceImplement.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("storage")
public class StorageProperties {
    private String location = "D:\\Рома програмування\\Idea\\mainproject\\src\\main\\resources\\static\\storageFile";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
