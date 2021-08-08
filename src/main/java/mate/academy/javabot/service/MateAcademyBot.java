package mate.academy.javabot.service;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

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
    }
}
