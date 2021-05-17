package com.telegrambot.core;

/**
 *
 * @author gayanec
 */
public class BotMessage {

    private final int CHAT_ID;
    private final String text;

    public BotMessage(int CHAT_ID, String text) {
        this.CHAT_ID = CHAT_ID;
        this.text = text;
    }

    public int getCHAT_ID() {
        return CHAT_ID;
    }

    public String getText() {
        return text;
    }
    
    
    public void send(){
    
    }

}
