package com.tradingbot.app.ws.ui.model.response;

public class UserLoginResModel {
    private String username;
    private String email;
    private String userId;
    private String message;

    // getters and settings

    public String getMessage() {
        return message;
    }

    public String setMessage(String message) {
        this.message = message + this.username;
        return this.message;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
}
