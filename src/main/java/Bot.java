import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        try {
            sendMsg(message, "Что хотите то?");
        } catch (TelegramApiException e) {
            System.out.println(e);
    }
    }
    public void sendMsg(Message message, String s) throws TelegramApiException
    {

        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(s);
        execute(sendMessage);
    }

    @Override
    public String getBotUsername() {
        // Return bot username
        // If bot username is @MyAmazingBot, it must return 'MyAmazingBot'
        return "gneirneingbot";
    }

    @Override
    public String getBotToken() {
        // Return bot token from BotFather
        return "5248865858:AAGkkitySxGcA4_-kwLLC-z1wXcZI1iJncc";
    }
}