package com.gfa.chat.models;

public class UserRequestDTO {
        String login;
        String password;

        public UserRequestDTO(String login, String password) {
        this.login = login;
        this.password = password;
        }

public UserRequestDTO() {
        }

        public String getLogin() {
                return login;
        }

        public void setLogin(String login) {
                this.login = login;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }
}