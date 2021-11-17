package uz.pdp.FirstTask;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import uz.pdp.entity.RegisterForm;


import java.util.ArrayList;
import java.util.List;

public class CashConverter extends TelegramLongPollingBot {
    public static int counterMessage = 0;
    RegisterForm registerForm=new RegisterForm();
    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi api = new TelegramBotsApi();
        try {
            api.registerBot(new CashConverter());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }

    }

    @Override
    public  void onUpdateReceived(Update update) {




        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId());
        if (update.hasMessage()) {
            String inputText = update.getMessage().getText();
            System.out.println(inputText);
            System.out.println(update.getMessage().getChatId());
            if (inputText.equals("/start")) {
                counterMessage=0;
                sendMessage.setText("ASSALOMU ALAYKUM! \n\n" +
                        "\"O'Z-O'ZINI ANGLASH\" webinariga qiziqish bildirganingizdan juda xursandmiz\n\n" +
                        "Webinarda qatnashish uchun kichik ro'yxatdan o'tishingiz kerak\n\n" +
                        "FAMILIYA, ISM, SHARIFINGIZNI KIRITING:");
                counterMessage++;;

            }else if(inputText.equals("/ok")){

                sendMessage.setChatId(280692014l);
//                sendMessage.setChatId(575428234l);
                sendMessage.setText(registerForm.toString());
            }
            else  if (counterMessage==1){
                registerForm.setFullName(inputText);
                sendMessage.setText("Yoshingizni kiriting:");

                counterMessage++;

            }else if (counterMessage==2){
                registerForm.setAge(inputText);
                sendMessage.setText("Yashash manzilingizni kiriting:\n" +
                        "(Viloyat, shahar, tuman)");
                counterMessage++;

            }else if (counterMessage==3){
                registerForm.setAddress(inputText);
                sendMessage.setText("Kasbiy faoliyatingizni kiriting:\n" +
                        "(Talaba bo'lsangiz o'qish joyingizni kiriting");
                counterMessage++;

            }else if (counterMessage==4){
                registerForm.setProfession(inputText);
                sendMessage.setText("kiritilgan ma'lumotlarni tekshirib chiqing\n"+
                        "FIO: "+registerForm.getFullName()+",\n" +
                        "yoshigiz: "+registerForm.getAge()+",\n" +
                        "manzilingiz: "+registerForm.getAddress()+",\n" +
                        "kasbiy faoliyatingiz: "+registerForm.getProfession()+".\n" +
                        "Kiritilgan ma'lumotlar to'g'ri bo'lsa /ok yuboring aks holda /start");


            }

        }

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getBotUsername() {
        return "UzsToUsdBot";
    }

    @Override
    public String getBotToken() {
        return "1711231832:AAEtGLAgrokCeJsayE-BO-5V6aG_Ux83pCc";
    }
}
