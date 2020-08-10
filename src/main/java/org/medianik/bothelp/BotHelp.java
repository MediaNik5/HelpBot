package org.medianik.bothelp;


import org.medianik.bothelp.Config.BotInfo;
import org.medianik.bothelp.messages.MessageHandler;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;



public class BotHelp extends TelegramLongPollingBot {


    private static BotHelp instance = new BotHelp();

    public static MessageHandler getMessageHandler(){
        return MessageHandler.getInstance(instance);
    }

    public static void main(String[] ignored){
        log("Initialisation started");
        ApiContextInitializer.init();
        TelegramBotsApi api = new TelegramBotsApi();
        try{
            api.registerBot(instance);
            log("initialisation completed");
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }

    public void onUpdateReceived(Update update) {

    }

    public static <E> void log(E o){
        System.out.println(o);
    }
    public String getBotUsername(){ return BotInfo.botName; }
    public String getBotToken(){ return BotInfo.token; }
}
