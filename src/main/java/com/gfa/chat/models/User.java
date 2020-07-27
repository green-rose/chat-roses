package com.gfa.chat.models;

public class User {
 int userId;
         String username;
         String avatarUrl;

public User(int userId, String username, String avatarUrl) {
        this.userId = userId;
        this.username = username;
        this.avatarUrl = avatarUrl;
        }

public User() {
        }

public int getUserId() {
        return userId;
        }

public void setUserId(int userId) {
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
        }