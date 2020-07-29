package com.gfa.chat.services;

import com.gfa.chat.models.*;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class MsgServiceImpl implements MsgService  {

    @Override
    public ResponseEntity<?> send(MsgRequestDTO msg, String keyApi) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("apiKey", keyApi);
        Map<String, Object> data = new HashMap<>();
        data.put("channelId", null);
        data.put("channelSecret", null);
        data.put("content", msg.getContent());
        try {
            ResponseEntity<?> response = restTemplate.postForEntity(UserServiceImpl.rascalAppPath + "/api/message", new HttpEntity<>(data, headers), MsgResponseDTO.class);
            if (response.getStatusCode() == HttpStatus.OK) {
                MsgResponseDTO msgResponseDTO = (MsgResponseDTO) response.getBody();
                return new ResponseEntity<>(msgResponseDTO, HttpStatus.OK);
            }  else return new ResponseEntity<>(new CustomError(), HttpStatus.BAD_REQUEST);
        }
        catch (Exception exception) {
            return new ResponseEntity<>(new CustomError(exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> get(String keyApi, Integer channelId) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("apiKey", keyApi);
        Map<String, Object> data = new HashMap<>();
        data.put("channelId", channelId);
        data.put("channelSecret", null);
        data.put("count",5);
        try {
            ResponseEntity<?> response = restTemplate.postForEntity(UserServiceImpl.rascalAppPath + "/api/channel/get-messages", new HttpEntity<>(data, headers), String.class);
            if (response.getStatusCode() == HttpStatus.OK) {
                JSONObject jsonObject = (JSONObject) response.getBody();
                return new ResponseEntity<>(jsonObject, HttpStatus.OK);
            }  else return new ResponseEntity<>(new CustomError(), HttpStatus.BAD_REQUEST);
        }
        catch (Exception exception) {
            return new ResponseEntity<>(new CustomError(exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

}
