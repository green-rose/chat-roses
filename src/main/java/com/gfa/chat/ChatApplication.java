package com.gfa.chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatApplication {

    public static void main(String[] args) {
        System.out.println(System.getenv("chatURL"));
        SpringApplication.run(ChatApplication.class, args);
    }

}
