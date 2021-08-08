package mate.academy.javabot.service;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

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

        if (message.getText().equals("/start")) {
            StringBuilder text = new StringBuilder();
            text.append("Welcome to Recipe Bot! Please choose the meal of the day!\n");

            sendMessage.enableMarkdown(true);
            ReplyKeyboardMarkup keyboardMarkup = getMenuKeyboard();
            sendMessage.setReplyMarkup(keyboardMarkup);

            sendMessage.setText(text.toString());
        }

        if (message.getText().equals("breakfast")) {
            StringBuilder menu = new StringBuilder("Breakfast menu\n");
            menu.append("1. Blueberry-Banana-Nut Smoothie\n");
            menu.append("2. Classic Omelet and Greens\n");
            menu.append("3. Curry-Avocado Crispy Egg Toast\n");

            sendMessage.setText(menu.toString());
        }

        if (message.getText().equals("dinner")) {
            StringBuilder menu = new StringBuilder("Dinner menu\n");
            menu.append("1. Creamy Lemon Chicken Pasta\n");
            menu.append("2. Turkey Takos\n");
            menu.append("3. Vegetarian Lasagna\n");

            sendMessage.setText(menu.toString());
        }

        if (message.getText().equals("lunch")) {
            StringBuilder text = new StringBuilder("Lunch menu is in progress...\n");
            sendMessage.setText(text.toString());
        }

        if (message.getText().equals("supper")) {
            StringBuilder text = new StringBuilder("Supper menu is in progress...\n");
            sendMessage.setText(text.toString());
        }

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private ReplyKeyboardMarkup getMenuKeyboard(){
        // ReplyKeyboardMarkup
        // a set of buttons that will be displayed in the telegram.
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add("breakfast");
        keyboardRow.add("dinner");

        KeyboardRow keyboardSecondRow = new KeyboardRow();
        keyboardSecondRow.add("lunch");
        keyboardSecondRow.add("supper");

        keyboardRows.add(keyboardRow);
        keyboardRows.add(keyboardSecondRow);

        replyKeyboardMarkup.setKeyboard(keyboardRows);

        return replyKeyboardMarkup;
    }
}
