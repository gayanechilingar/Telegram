package com.telegrambot.core;

import com.telegrambot.domain.Client;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public class HttpClient {                    
                
    @Autowired
    private static final Client CLIENT = new Client();

    @PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity  createClient(@RequestBody Client client) {
        Optional<Client> savedClient = client.createClient(client);

        if (savedClient.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(savedClient.get());
        }

        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Sorry I cant save this client, please try again!!!!!");
    }
    
} 

