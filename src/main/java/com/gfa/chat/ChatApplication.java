package com.gfa.chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.gfa.chat.services.UserServiceImpl.rascalAppPath;

@SpringBootApplication
public class ChatApplication {

    public static void main(String[] args) {
        rascalAppPath= System.getenv("chatURL");
        SpringApplication.run(ChatApplication.class, args);
    }

}
