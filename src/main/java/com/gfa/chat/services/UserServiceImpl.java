package com.gfa.chat.services;

import com.gfa.chat.models.CustomError;
import com.gfa.chat.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService  {
    public static String rascalAppPath;

    public ResponseEntity<?> registered(User user){
        RestTemplate restTemplate = new RestTemplate();

        Map<String, Object> data = new HashMap<>();
        data.put("login", user.getUsername());
        data.put("password", user.getPassword());

        ResponseEntity<?> response = restTemplate.postForEntity(rascalAppPath+"/api/user/register", data, User.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            User incomingUser  = (User) response.getBody();
            user.setUserId(incomingUser.getUserId());
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else return new ResponseEntity<>(new CustomError(), HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<?> login(User user) {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, Object> data = new HashMap<>();
        data.put("login", user.getUsername());
        data.put("password", user.getPassword());

        ResponseEntity<?> response = restTemplate.postForEntity(rascalAppPath+"/api/user/login", data, User.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            User incomingUser  = (User) response.getBody();
            user.setApiKey(incomingUser.getApiKey());
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else return new ResponseEntity<>(new CustomError(), HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<?> update(User user) {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, Object> data = new HashMap<>();
        data.put("username", user.getUsername());
        data.put("avatarUrl", user.getAvatarUrl());

        ResponseEntity<?> response = restTemplate.postForEntity(rascalAppPath+"/api/user/update", data, User.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else return new ResponseEntity<>(new CustomError(), HttpStatus.BAD_REQUEST);
    }

}
