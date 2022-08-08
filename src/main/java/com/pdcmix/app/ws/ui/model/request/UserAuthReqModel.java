package com.tradingbot.app.ws.ui.model.request;

public class UserAuthReqModel {
    private String username;
    private String email;
    private String password;

    // getters and settings for fields
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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
