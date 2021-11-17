package uz.pdp;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;


import java.util.ArrayList;
import java.util.List;


public class TelebotApiExample extends TelegramLongPollingBot {
    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi api = new TelegramBotsApi();
        try {
            api.registerBot(new TelebotApiExample());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotToken() {
        return "1306126993:AAEPPTvrj6vgPN_-pJNHx5SsqZlxNnRLZzc";
    }

    @Override
    public String getBotUsername() {
        return "eeeetestbot";
    }

    @Override
    public void onUpdateReceived(Update update) {
        String rateStr=null;

        System.out.println("ishladi");
        SendMessage sendMessage =new SendMessage();
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        List<InlineKeyboardButton> rows1 = new ArrayList<InlineKeyboardButton>();
        InlineKeyboardButton iButton1 = new InlineKeyboardButton("UZS->USD");
        iButton1.setCallbackData("UZS->USD");
        InlineKeyboardButton iButton2 = new InlineKeyboardButton("USD->UZS");
        iButton2.setCallbackData("USD->UZS");
        rows1.add(iButton1);
        rows1.add(iButton2);
        rows.add(rows1);
        List<InlineKeyboardButton> rows2 = new ArrayList<>();
        InlineKeyboardButton iButton3 = new InlineKeyboardButton("UZS->Euro");
        iButton3.setCallbackData("UZS->Euro");
        InlineKeyboardButton iButton4 = new InlineKeyboardButton("Euro->UZS");
        iButton4.setCallbackData("Euro->UZS");
        rows2.add(iButton3);
        rows2.add(iButton4);
        rows.add(rows2);
        List<InlineKeyboardButton> rows3 = new ArrayList<>();
        InlineKeyboardButton iButton5 = new InlineKeyboardButton("UZS->CNY");
        iButton5.setCallbackData("UZS->CNY");
        InlineKeyboardButton iButton6 = new InlineKeyboardButton("CNY->UZS");
        iButton6.setCallbackData("CNY->UZS");
        rows3.add(iButton5);
        rows3.add(iButton6);
        rows.add(rows3);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        inlineKeyboardMarkup.setKeyboard(rows);
//        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
//        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
//        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
//        List<InlineKeyboardButton> rows1 = new ArrayList<InlineKeyboardButton>();
//        InlineKeyboardButton iButton1 = new InlineKeyboardButton("UZS->USD");
//        iButton1.setCallbackData("UZS->USD");
//        InlineKeyboardButton iButton2 = new InlineKeyboardButton("USD->UZS");
//        iButton2.setCallbackData("USD->UZS");
//        rows1.add(iButton1);
//        rows1.add(iButton2);
//        rows.add(rows1);
//        List<InlineKeyboardButton> rows2 = new ArrayList<>();
//        InlineKeyboardButton iButton3 = new InlineKeyboardButton("UZS->Euro");
//        iButton3.setCallbackData("UZS->Euro");
//        InlineKeyboardButton iButton4 = new InlineKeyboardButton("Euro->UZS");
//        iButton4.setCallbackData("Euro->UZS");
//        rows2.add(iButton3);
//        rows2.add(iButton4);
//        rows.add(rows2);
//        List<InlineKeyboardButton> rows3 = new ArrayList<>();
//        InlineKeyboardButton iButton5 = new InlineKeyboardButton("UZS->Euro");
//        iButton5.setCallbackData("UZS->Euro");
//        InlineKeyboardButton iButton6 = new InlineKeyboardButton("Euro->UZS");
//        iButton6.setCallbackData("Euro->UZS");
//        rows3.add(iButton5);
//        rows3.add(iButton6);
//        rows.add(rows3);
        if (update.hasCallbackQuery()) {
//            sendMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
//
//            String callBackText = update.getCallbackQuery().getData();
//
//            if (callBackText.equals("UZS->USD")) {
//                sendMessage.setText("UZS->USD tanlandi summani kiriting");
//            } else if (callBackText.equals("222222")) {
//                sendMessage.setText("улвоооооос");
//            } else if (callBackText.equals("333333")) {
//                sendMessage.setText("ващееее энди эээ");
//            }
            String callBackQueryText=update.getCallbackQuery().getData();
            sendMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());
            System.out.println(callBackQueryText);
            if (callBackQueryText.equals("UZS->USD")){

                System.out.println("ishladi");
            }else if (callBackQueryText.equals("USD->UZS")){
                sendMessage.setText("ishlamadi");
                System.out.println("ishlamadi");
            }
        }
        else if (update.hasMessage()) {


            String inputText = update.getMessage().getText();

            sendMessage.setChatId(update.getMessage().getChatId());
            if (inputText.equals("/start")) {
                System.out.println(sendMessage);
                sendMessage.setText("Welcome to this bot\n I can only repeat");

//                String [] args=new String[3];
//                Main.main(args);
//
//
//                inlineKeyboardMarkup.setKeyboard(rows);

//                String [] args=new String[3];
//                Main.main(args);
//                System.out.println(Main.usDollar);
//
//
//                InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
//                sendMessage.setReplyMarkup(inlineKeyboardMarkup);
//                List<List<InlineKeyboardButton>> rows = new ArrayList<>();
//                List<InlineKeyboardButton> rows1 = new ArrayList<InlineKeyboardButton>();
//                InlineKeyboardButton iButton1 = new InlineKeyboardButton("1111");
//                iButton1.setCallbackData("111111");
//                InlineKeyboardButton iButton2 = new InlineKeyboardButton("2222");
//                iButton2.setCallbackData("222222");
//                rows1.add(iButton1);
//                rows1.add(iButton2);
//                rows.add(rows1);
//                List<InlineKeyboardButton> rows2 = new ArrayList<>();
//                InlineKeyboardButton iButton3 = new InlineKeyboardButton("3333");
//                iButton3.setCallbackData("333333");
//                rows2.add(iButton3);
//                rows.add(rows2);
//                inlineKeyboardMarkup.setKeyboard(rows);
//                sendMessage.setText("Welcome to this bot\n I can only repeat");

            } else {
                if (inputText.equalsIgnoreCase("Hello") || inputText.equalsIgnoreCase("Good day")) {
                    sendMessage.setText("Have a good day");
//                    inlineKeyboardMarkup.setKeyboard(rows);
                } else if (inputText.equalsIgnoreCase("Hi")) {
                    sendMessage.setText("Hola");
//                    inlineKeyboardMarkup.setKeyboard(rows);

                } else {
                    sendMessage.setText(inputText);
                    sendMessage.setChatId(update.getMessage().getChatId());
                }
                ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
                sendMessage.setReplyMarkup(keyboardMarkup);
                keyboardMarkup.setResizeKeyboard(true);
                keyboardMarkup.setOneTimeKeyboard(true);
                keyboardMarkup.setSelective(true);
                List<KeyboardRow> keyboardRows = new ArrayList<>();
                KeyboardRow row1 = new KeyboardRow();
                KeyboardButton button1 = new KeyboardButton("Hello");
                KeyboardButton button2 = new KeyboardButton("Good day");
                row1.add(button1);
                row1.add(button2);
                KeyboardRow row2 = new KeyboardRow();
                row2.add("Hi");
                keyboardRows.add(row1);
                keyboardRows.add(row2);
                keyboardMarkup.setKeyboard(keyboardRows);
//                inlineKeyboardMarkup.setKeyboard(rows);


            }
        }
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }


}
