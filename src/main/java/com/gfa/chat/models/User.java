package com.gfa.chat.models;

public class User {
        Integer userId;
        String username;
        String avatarUrl;
        String password;
        String apiKey;

        public String getApiKey() {
                return apiKey;
        }

        public void setApiKey(String apiKey) {
                this.apiKey = apiKey;
        }

        public User(int userId, String username, String password, String avatarUrl, String apiKey) {
        this.userId = userId;
        this.username = username;
        this.avatarUrl = avatarUrl;
        this.password = password;
        this.apiKey = apiKey;
        }

public User(String username, String password) {
        this.userId = null;
        this.username = username;
        this.avatarUrl = null;
        this.password = password;
        this.apiKey = null;
}


public User() {
        }

public int getUserId() {
        return userId;
        }

public void setUserId(Integer userId) {
        this.userId = userId;
        }

public String getUsername() {
        return username;
        }

public void setUsername(String username) {
        this.username = username;
        }

public String getAvatarUrl() {
        return avatarUrl;
        }

public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
        }

public String getPassword() {
        return password;
}

public void setPassword(String password) {
        this.password = password;
}
}