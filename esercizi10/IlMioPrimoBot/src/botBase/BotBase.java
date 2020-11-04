package botBase;

import com.botticelli.bot.Bot;
import com.botticelli.bot.request.methods.MessageToSend;
import com.botticelli.bot.request.methods.StickerReferenceToSend;
import com.botticelli.bot.request.methods.types.*;

import java.util.ArrayList;
import java.util.List;

import static botBase.ComandoBotBase.*;

public class BotBase extends Bot {

    public BotBase(String token)
    {
        super(token);
    }

    @Override
    public void textMessage(Message message) {
        ComandoBotBase c = fromString(message.getText());
        MessageToSend mts = null;
        switch (c)
        {
            case SALUTA:
                String name = message.getChat().getUserName();
                if(name == null) name = message.getChat().getFirstName();
                if(name == null) name= "";
                mts = new MessageToSend(message.getChat().getId(), "Ciao "+name+", come stai?");
                break;
            case MONOPATTINO:
                mts = new MessageToSend(message.getChat().getId(), "Esercizio Facile");
                break;
            case SCOOTER:
                mts = new MessageToSend(message.getChat().getId(), "Esercizio Medio");
                break;
            case MOTO:
                mts = new MessageToSend(message.getChat().getId(), "Esercizio Avanzato");
                break;
            case TASTIERA:
                List<List<KeyboardButton>> keyboard = new ArrayList<>();
                List<KeyboardButton> line = new ArrayList<>();
                line.add(new KeyboardButton("\uD83D\uDEF4"));
                line.add(new KeyboardButton("\uD83D\uDEF5"));
                line.add(new KeyboardButton("\uD83C\uDFCD"));
                keyboard.add(line);
                ReplyKeyboardMarkupWithButtons replyKeyboard = new ReplyKeyboardMarkupWithButtons(keyboard);
                replyKeyboard.setResizeKeyboard(true);
                mts = new MessageToSend(message.getFrom().getId(), "Ecco la tastiera");
                mts.setReplyMarkup(replyKeyboard);
                break;
            case ERRORE:
                mts = new MessageToSend(message.getChat().getId(), "Input non riconosciuto!");
        }
        sendMessage(mts);
    }

    @Override
    public void audioMessage(Message message) {

    }

    @Override
    public void videoMessage(Message message) {

    }

    @Override
    public void voiceMessage(Message message) {

    }

    @Override
    public void stickerMessage(Message message) {
        MessageToSend mts = new MessageToSend(message.getChat().getId(), "Bello sto sticker! Guarda questo");
        sendMessage(mts);
        sendStickerbyReference(new StickerReferenceToSend(message.getFrom().getId(), "CAACAgIAAxkBAAMCX6J94LxR9XowJBICBa0a-1prKGsAAoUCAAJWnb0KowlyEF-XJhkeBA"));
    }

    @Override
    public void documentMessage(Message message) {

    }

    @Override
    public void photoMessage(Message message) {

    }

    @Override
    public void contactMessage(Message message) {

    }

    @Override
    public void locationMessage(Message message) {

    }

    @Override
    public void venueMessage(Message message) {

    }

    @Override
    public void newChatMemberMessage(Message message) {

    }

    @Override
    public void newChatMembersMessage(Message message) {

    }

    @Override
    public void leftChatMemberMessage(Message message) {

    }

    @Override
    public void newChatTitleMessage(Message message) {

    }

    @Override
    public void newChatPhotoMessage(Message message) {

    }

    @Override
    public void groupChatPhotoDeleteMessage(Message message) {

    }

    @Override
    public void groupChatCreatedMessage(Message message) {

    }

    @Override
    public void inLineQuery(InlineQuery inlineQuery) {

    }

    @Override
    public void chose_inline_result(ChosenInlineResult chosenInlineResult) {

    }

    @Override
    public void callback_query(CallbackQuery callbackQuery) {

    }

    @Override
    public void gameMessage(Message message) {

    }

    @Override
    public void videoNoteMessage(Message message) {

    }

    @Override
    public void pinnedMessage(Message message) {

    }

    @Override
    public void preCheckOutQueryMessage(PreCheckoutQuery preCheckoutQuery) {

    }

    @Override
    public void shippingQueryMessage(ShippingQuery shippingQuery) {

    }

    @Override
    public void invoiceMessage(Message message) {

    }

    @Override
    public void successfulPaymentMessage(Message message) {

    }

    @Override
    public void routine() {

    }
}
