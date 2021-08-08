package mate.academy.javabot.service;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
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
        Message message = update.getMessage();
        System.out.println("Message received " + message.getText());
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Hello user! I received your message: " + message.getText());
        sendMessage.setChatId(String.valueOf(message.getChatId())); // to which user (dialogue) the message will be sent

        if(message.getText().equals("breakfast")){
            StringBuilder menu = new StringBuilder("Breakfast menu\n");
            menu.append("1. Blueberry-Banana-Nut Smoothie\n");
            menu.append("2. Classic Omelet and Greens\n");
            menu.append("3. Curry-Avocado Crispy Egg Toast\n");

            sendMessage.setText(menu.toString());
        }

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
