package com.gfa.chat.services;

import com.gfa.chat.models.User;
import com.gfa.chat.models.UserUpdateDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public interface UserService {
    public ResponseEntity<?> registered(User user);

    public ResponseEntity<?> login(User user);

    public ResponseEntity<?> update(UserUpdateDTO newUser, User user);

    boolean logout(User user);
}
