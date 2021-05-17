package telegrambot;

import telegrambot.area.AreaFinding;
import java.awt.geom.Area;
import telegrambot.ReadProperties;
import telegrambot.weather.WeatherParsing;
import lombok.SneakyThrows;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import telegrambot.weather.WeatherParsing;

public class GayaneBot extends TelegramLongPollingBot {

    WeatherParsing Weather = new WeatherParsing();

    ReadProperties prop = new ReadProperties();

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage()) {

            //we save the message in new Message object
            Message message = update.getMessage();

            //we check that the text is not empty
            if (message != null && message.hasText()) {

                //we take the text, and convert it to lower case, so even if the user typed "/HELLO" it should work
                String msg = message.getText().toLowerCase();

                //now we tell the bot to respond to specific cases:
                if (msg.equals("/start")) {
                    SendMsg(message, "Ok! let's go 😀");
                }
                else if (msg.startsWith("/hello")) {
                    SendMsg(message, "Hello World!");
                }  
                else if (msg.equals("/let"+"'s go")) {
                    SendMsg(message, "Ok! let's get the party started 😀");
                    SendMsg(message, "What is your name?");
//                    message = update.getMessage();
                }
                else if (msg.startsWith("/myname")){
                    SendMsg(message, "Good");
                    
                }
                    
                
                
            }
        }

//        System.out.println(update.getMessage().getText());
//
//        Long chat_id = update.getMessage().getChatId();
//        sendMsg("Hi! What is your name? ", chat_id);
//        String message = update.getMessage().getText();
//        
//        if(message.equals(null)){
//            
//        }
//        while(message.length()<=2){
//            
//            message = update.getMessage().getText();
//        }
//        message = update.getMessage().getText();
//        if(message.length()>=3){
//            sendMsg("What do you want? " , chat_id);
//            message = update.getMessage().getText();
//            
//        }
//        
//        sendMsg("bot answer is " + message, chat_id);
//        if (update.hasMessage()) {
//        System.out.println("update.getMessage() " + update.getMessage());
//        String longitude = update.getMessage().getLocation().getLongitude().toString();
//        String latitude = update.getMessage().getLocation().getLatitude().toString();
//        String city = AreaFinding.getCity(longitude, latitude);
//        sendMsg("Вы находитесь в городе "
//                + "\nПогода в городе " + " равна " + "℃"
//                + "\nКоличество заболевших в стране " + "NONE" + " за сегодня " + "NONE" + " человек"
//                + "\nВалюта: " + "NONE", chat_id);
//        }  
    }

    @SneakyThrows
    public synchronized void sendMsg(String s, Long chat_id) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chat_id + "print chat id");
        sendMessage.setText(s);
        sendMessage.setReplyMarkup(null);
        execute(sendMessage);
    }

    public String getBotUsername() {
        return "GayaneSpeaker_bot";
    }

    public String getBotToken() {
        return "1898172709:AAHiTX6I8eRK37BouPTWyiKU4VyloJqY2SI";
    }

    protected boolean filter(Message message) {
        return false;
    }

    public void Messages(Update update) {
        Long chat_id = update.getMessage().getChatId();
        String message = update.getMessage().getText();
        sendMsg("Your name is short. Please write again. ", chat_id);
        message = update.getMessage().getText();
        sendMsg("What is your name? ", chat_id);
    }
    
    public void SendMsg(Message message, String s) {
		SendMessage sendMessage = new SendMessage();
		
		//set the destination, and the text we want to send
		sendMessage.setChatId(message.getChatId().toString());
		sendMessage.setText(s);
		
		//try to send it:
		try {
			execute(sendMessage);
		}
		catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

}
