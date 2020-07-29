package com.gfa.chat.services;

import com.gfa.chat.models.CustomError;
import com.gfa.chat.models.User;
import com.gfa.chat.models.UserUpdateDTO;
import org.springframework.http.*;
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

        try {
            ResponseEntity<?> response = restTemplate.postForEntity(rascalAppPath + "/api/user/register", data, User.class);
            if (response.getStatusCode() == HttpStatus.OK) {
                User incomingUser = (User) response.getBody();
                user.setUserId(incomingUser.getUserId());
                return new ResponseEntity<>(user, HttpStatus.OK);
            }  else return new ResponseEntity<>(new CustomError(), HttpStatus.BAD_REQUEST);
        }
        catch (Exception exception) {
            return new ResponseEntity<>(new CustomError(exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
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
    public ResponseEntity<?> update(UserUpdateDTO userUpdateDTO, User user) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("apiKey", user.getApiKey());
        Map<String, Object> data = new HashMap<>();
        data.put("username", userUpdateDTO.getUsername());
        data.put("avatarUrl", userUpdateDTO.getAvatarUrl());

        ResponseEntity<?> response = restTemplate.postForEntity(
                rascalAppPath+"/api/user/update", new HttpEntity<>(data, headers),
                User.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            User incomingUser  = (User) response.getBody();
            user.setUsername(incomingUser.getUsername());
            user.setAvatarUrl(incomingUser.getAvatarUrl());
            user.setUserId(incomingUser.getUserId());
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else return new ResponseEntity<>(new CustomError(), HttpStatus.BAD_REQUEST);
    }

    @Override
    public boolean logout(User user) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("apiKey", user.getApiKey());
        ResponseEntity<String> response = restTemplate.postForEntity(
                rascalAppPath+"/api/user/logout", new HttpEntity<>("", headers),
                String.class);
        if (response.getStatusCode() == HttpStatus.OK && "true".equals(response.getBody())) {
            return true;
        } else return false;
    }

}
