package com.data.client.api.model;

public enum ResponseMessage {

    SUCCESS("Data Pushed to Server successfully"),
    FAILURE("Data Push failed"),
    UNIQUE("Data Push failed, Data Header name needs to be unique");

    private String description;

     ResponseMessage(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
