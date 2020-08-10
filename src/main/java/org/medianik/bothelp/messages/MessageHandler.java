package org.medianik.bothelp.messages;

import org.medianik.bothelp.BotHelp;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Objects;

public class MessageHandler {


    protected BotHelp bot;
    private static MessageHandler messageHandler;

    public static MessageHandler getInstance(BotHelp bot){
        createIfNotCreated(bot);
        return messageHandler;
    }
    private static void createIfNotCreated(BotHelp bot){
        if(messageHandler == null)
            messageHandler = new MessageHandler();
        if(messageHandler.bot == null)
            messageHandler.setBot(Objects.requireNonNull(bot));

    }
    private MessageHandler(){}

    private void setBot(BotHelp bot){
        this.bot = bot;
    }

    public void deleteMessage(long chatId, int messageId){
        DeleteMessage messageToDelete = new DeleteMessage()
                .setChatId(chatId)
                .setMessageId(messageId);
        try{
            bot.execute(messageToDelete);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
