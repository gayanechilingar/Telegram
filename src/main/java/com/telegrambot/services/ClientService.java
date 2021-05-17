/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telegrambot.services;

import com.telegrambot.domain.Client;
import com.telegrambot.repositories.ClientRepository;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Slf4j
public class ClientService {


    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public Optional<Client> createClient(Client client) {

        client.setId(null);

        if (client.getUserId() == null) {
            log.error("You should provide user id");
            return Optional.empty();
        }

        log.info("user id " + client.getUserId());
        Optional<Client> existingClient = clientRepository.findByUserId(client.getUserId());

        if (existingClient.isPresent()) {
            log.error("User already has order, we cant save new client");
            return Optional.empty();
        }


        Client savedClient = clientRepository.save(client);

        log.info("order is saved and order id is " + savedClient.getId());

        return Optional.ofNullable(savedClient);
    }
}