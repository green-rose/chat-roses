package com.gfa.chat.services;

import com.gfa.chat.models.MsgRequestDTO;
import com.gfa.chat.models.User;
import com.gfa.chat.models.UserUpdateDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public interface MsgService {
    public ResponseEntity<?> send(MsgRequestDTO msg, String keyApi);

    public ResponseEntity<?> get(String keyApi, Integer channelId);
}
