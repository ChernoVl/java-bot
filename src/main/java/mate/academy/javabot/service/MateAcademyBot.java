package mate.academy.javabot.service;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class MateAcademyBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "recipe_by_1234_bot";
    }

    @Override
    public String getBotToken() {
        return "1920925503:AAFkmqiCn1ANjNc13BoQ5-ZAJ6AZR22PGa4";
    }

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println("Message received " + update.getMessage().getText());
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Hello user! I received your message: " + update.getMessage().getText());
        sendMessage.setChatId(String.valueOf(update.getMessage().getChatId())); // to which user (dialogue) the message will be sent

        if(update.getMessage().getText().equals("breakfast")){
            sendMessage.setText("Breakfast menu");
        }

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
