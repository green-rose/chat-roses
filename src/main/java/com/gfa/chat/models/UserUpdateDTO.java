package com.gfa.chat.models;

public class UserUpdateDTO {
        String username;
        String avatarUrl;

        public UserUpdateDTO(String username, String avatarUrl) {
        this.username = username;
        this.avatarUrl = avatarUrl;
        }

        public UserUpdateDTO() {
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