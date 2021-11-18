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


import java.util.*;

public class CashConverter extends TelegramLongPollingBot {
    private static Map<Long, RegisterForm> registerFormMap = new HashMap<>();
    //    public static int counterMessage = 0;
    private RegisterForm registerForm;

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
    public void onUpdateReceived(Update update) {



            registerForm = registerFormMap.putIfAbsent(update.getMessage().getChatId(), new RegisterForm());
            if (registerForm == null) {
                registerForm = new RegisterForm();
            }
            int counterMessage = registerForm.getCounterMessage();


            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(update.getMessage().getChatId());
            if (update.hasMessage()) {
                String inputText = update.getMessage().getText();
                System.out.println(inputText);
                System.out.println(update.getMessage().getChatId());
                if (inputText.equals("/start")) {

                    counterMessage = 0;
                    sendMessage.setText("ASSALOMU ALAYKUM! \n\n" +
                            "\"O'Z-O'ZINI ANGLASH\" webinariga qiziqish bildirganingizdan juda xursandmiz\n\n" +
                            "Webinarda qatnashish uchun kichik ro'yxatdan o'tishingiz kerak\n\n" +
                            "FAMILIYA, ISM, SHARIFINGIZNI KIRITING:");
                    counterMessage++;
                    registerForm.setCounterMessage(counterMessage);
                    registerForm.setChatId(update.getMessage().getChatId());
                    if (registerForm.isSentToAdmin()) {
                        registerForm.setCounterMessage(6);
                        sendMessage.setText("Siz ro'yxatdan o'tib bo'lgansiz.");
                    }

                } else if (inputText.equals("/ok")) {
                    registerForm.setSentToAdmin(true);

                    sendMessage.setChatId(280692014l);
//                sendMessage.setChatId(575428234l);
                    sendMessage.setText(this.registerForm.toString());
                } else if (registerForm.getCounterMessage() == 1) {
                    registerForm.setFullName(inputText);
                    sendMessage.setText("Yoshingizni kiriting:");

                    counterMessage++;
                    registerForm.setCounterMessage(counterMessage);

                } else if (registerForm.getCounterMessage() == 2) {
                    registerForm.setAge(inputText);
                    sendMessage.setText("Yashash manzilingizni kiriting:\n" +
                            "(Viloyat, shahar, tuman)");
                    counterMessage++;
                    registerForm.setCounterMessage(counterMessage);

                } else if (registerForm.getCounterMessage() == 3) {
                    registerForm.setAddress(inputText);
                    sendMessage.setText("Kasbiy faoliyatingizni kiriting:\n" +
                            "(Talaba bo'lsangiz o'qish joyingizni kiriting");
                    counterMessage++;
                    registerForm.setCounterMessage(counterMessage);

                } else if (registerForm.getCounterMessage() == 4) {
                    registerForm.setProfession(inputText);
                    sendMessage.setText("Kiritilgan ma'lumotlarni tekshirib chiqing\n\n" +
                            "FIO: " + this.registerForm.getFullName() + ",\n\n" +
                            "Yoshingiz: " + this.registerForm.getAge() + ",\n\n" +
                            "Manzilingiz: " + this.registerForm.getAddress() + ",\n\n" +
                            "Kasbiy faoliyatingiz: " + this.registerForm.getProfession() + ".\n\n" +
                            "Agar kiritilgan ma'lumotlar to'g'ri bo'lsa /ok ni bosing.\n\n" +
                            "Ma'lumotlarda xatolik bo'lsa, qaytadan ro'yxatdan o'tish uchun /start ni bosing.");
                    counterMessage++;
                    registerForm.setCounterMessage(counterMessage);


                } else if (registerForm.getCounterMessage() > 4) {
                    if (registerForm.isSentToAdmin()){

                        sendMessage.setText("Siz ro'yxatdan o'tdingiz\n\n");
                    }else {
                        sendMessage.setText("Ro'yxatdan to'liq o'tish uchun /ok ni bosing");
                    }
                }


            }

        registerFormMap.replace(update.getMessage().getChatId(), registerForm);
        try {

                execute(sendMessage);
                if (update.getMessage().getText().equals("/ok")){
                    if (registerForm.getCounterMessage()==5) {
                        sendMessage.setChatId(update.getMessage().getChatId());
                        sendMessage.setText("TABRIKLAYMIZ SIZ RO'YXATDAN O'TDINGIZ!!!\n\n" +
                                "Webinar haqida qo'shimcha ma'lumotlar olish uchun ushbu guruhga qo'shiling: \n\n" +
                                "https://t.me/Jonli_Vebinar ");
                        registerForm.setCounterMessage(10);
                        execute(sendMessage);
                    }

                }
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }



    @Override
    public String getBotUsername() {
        return "Vebinarda_Qatnashish_Bot";
    }

    @Override
    public String getBotToken() {
        return "2134878477:AAHFS-f8xuNHYDHBPgGuRtWbftShUpHYD7o";
    }
}
