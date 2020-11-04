package botRandomMedia;

import com.botticelli.bot.Bot;
import com.botticelli.bot.request.methods.*;
import com.botticelli.bot.request.methods.types.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class BotRandomMedia extends Bot {
    ArrayList<String> immagini;
    ArrayList<String> noteAudio;
    ArrayList<String> canzoni;
    ArrayList<String> stickers;
    Random rndm;


    public BotRandomMedia(String token)
    {
        super(token);
        immagini = new ArrayList<>();
        noteAudio = new ArrayList<>();
        canzoni = new ArrayList<>();
        stickers = new ArrayList<>();
        rndm = new Random();
    }

    @Override
    public void textMessage(Message message) {

    }

    @Override
    public void audioMessage(Message message) {
        canzoni.add(message.getAudio().getFileID());
        int index = rndm.nextInt(canzoni.size());
        sendAudiobyReference(new AudioReferenceToSend(message.getFrom().getId(),canzoni.get(index)));
    }

    @Override
    public void videoMessage(Message message) {

    }

    @Override
    public void voiceMessage(Message message) {
        noteAudio.add(message.getVoice().getFileID());
        int index = rndm.nextInt(noteAudio.size());
        sendVoicebyReference(new VoiceReferenceToSend(message.getFrom().getId(),noteAudio.get(index)));
    }

    @Override
    public void stickerMessage(Message message) {
        stickers.add( message.getSticker().getFileID() );
        int index = rndm.nextInt(stickers.size());
        sendStickerbyReference(new StickerReferenceToSend(message.getFrom().getId(),stickers.get(index)));
    }

    @Override
    public void documentMessage(Message message) {

    }

    @Override
    public void photoMessage(Message message) {
        immagini.add(message.getPhoto().get(0).getFileID());
        int index = rndm.nextInt(immagini.size());
        sendPhotobyReference(new PhotoReferenceToSend(message.getFrom().getId(), immagini.get(index)));
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
