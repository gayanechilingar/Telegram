package com.telegrambot.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import telegrambot.GayaneBot;

/**
 *
 * @author gayanec
 */

@SpringBootApplication
@EnableMongoRepositories("com.telegrambot.repositories")
@ComponentScan("com.telegrambot")
@EntityScan("com.telegrambot.domain")
public class TelegramBotMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            SpringApplication.run(TelegramBotMain.class, args);  
            ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new GayaneBot());

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    
    
}

