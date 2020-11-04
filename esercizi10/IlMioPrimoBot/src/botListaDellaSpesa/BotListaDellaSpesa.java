package botListaDellaSpesa;

import com.botticelli.bot.Bot;
import com.botticelli.bot.request.methods.MessageToSend;
import com.botticelli.bot.request.methods.types.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BotListaDellaSpesa extends Bot {
    public enum StatoBotLista {COMANDO, AGGIUNGI, RIMUOVI}

    Map<Long, ArrayList<String[]>> listeSpesa;
    StatoBotLista statoBotLista;

    public BotListaDellaSpesa(String token) {
        super(token);
        statoBotLista = StatoBotLista.COMANDO;
        listeSpesa = new HashMap<>();
    }

    @Override
    public void textMessage(Message message) {
        MessageToSend mts = null;
        ArrayList<String[]> listaSpesaUtente;

        switch (statoBotLista) {
            case COMANDO:
                ComandoBotSpesa c = ComandoBotSpesa.fromString(message.getText());
                switch (c) {
                    case START:
                        mts = new MessageToSend(message.getFrom().getId(), "Benvenuto, ora puoi gestire la tua lista cliccando su 'Aggiungi' o 'Rimuovi'." +
                                "\nPuoi vedere gli elementi attualmente inseriti cliccando su 'Lista della spesa'.");
                        listeSpesa.put(message.getFrom().getId(), new ArrayList<>());
                        mts.setReplyMarkup(tastiera());
                        break;
                    case LISTA:
                        mts = new MessageToSend(message.getChat().getId(), getStringLista(message.getFrom().getId()));
                        break;
                    case AGGIUNGI:
                        mts = new MessageToSend(message.getChat().getId(), "Aggiungi un elemento alla lista inviando un messaggio nel formato di stringa <nomeprodotto>-<quantità> (-1 per tornare al menù).");
                        statoBotLista = StatoBotLista.AGGIUNGI;
                        break;
                    case RIMUOVI:
                        if (listeSpesa.get(message.getFrom().getId()).size() > 0) {
                            mts = new MessageToSend(message.getChat().getId(), "Inserisci l'indice dell'elemento che vuoi rimuovere.");
                            statoBotLista = StatoBotLista.RIMUOVI;
                        } else {
                            mts = new MessageToSend(message.getChat().getId(), "La lista è vuota, non c'è niente da rimuovere!!!");
                        }
                        break;
                    case RESTART:
                        break;
                    case ERRORE:
                        mts = new MessageToSend(message.getChat().getId(), "Input non riconosciuto!");
                }
                break;
            case AGGIUNGI:
                String addResp = message.getText();
                String[] splittedResp = addResp.split("-");
                listaSpesaUtente = listeSpesa.get(message.getFrom().getId());
                if(splittedResp.length > 1 ){
                    try{
                        Integer.parseInt(splittedResp[1]);
                        listaSpesaUtente.add(new String[] {splittedResp[0],splittedResp[1]});
                        statoBotLista = StatoBotLista.COMANDO;
                    }catch(NumberFormatException e){
                        mts = new MessageToSend(message.getChat().getId(), "Input non corretto!");
                        statoBotLista = StatoBotLista.AGGIUNGI;
                    }
                }else{
                    listaSpesaUtente.add(new String[] {splittedResp[0],"1"});
                    statoBotLista = StatoBotLista.COMANDO;
                }

                mts = new MessageToSend(message.getChat().getId(), "Elemento aggiunto!");
                mts.setReplyMarkup(tastiera());
                break;
            case RIMUOVI:
                String remResp = message.getText();
                listaSpesaUtente = listeSpesa.get(message.getFrom().getId());
                int indice = -1;
                try {
                    indice = Integer.parseInt(remResp);
                    if (indice == -1) {
                        mts.setReplyMarkup(tastiera());
                        statoBotLista = StatoBotLista.COMANDO;
                    } else if (indice >= 0 && indice < listaSpesaUtente.size()) {
                        listaSpesaUtente.remove(indice);
                        mts = new MessageToSend(message.getChat().getId(), "Elemento rimosso!");
                        mts.setReplyMarkup(tastiera());
                        statoBotLista = StatoBotLista.COMANDO;
                    } else {
                        mts = new MessageToSend(message.getChat().getId(), "Indice non corretto!");
                    }
                } catch (NumberFormatException e) {
                    mts = new MessageToSend(message.getChat().getId(), "Input non riconosciuto!" +
                            "\nInserisci l'indice dell'elemento che vuoi rimuovere.");
                }
        }
        sendMessage(mts);
    }

    private String getStringLista(Long idUtente) {
        String ret = "";
        int size = listeSpesa.get(idUtente).size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                ret += i + " " + listeSpesa.get(idUtente).get(i)[0] + " " + listeSpesa.get(idUtente).get(i)[1] + "\n";
            }
        } else {
            ret += "Lista vuota!";
        }
        return ret;
    }

    private ReplyKeyboardMarkupWithButtons tastiera() {
        List<List<KeyboardButton>> keyboard = new ArrayList<>();
        List<KeyboardButton> line = new ArrayList<>();
        line.add(new KeyboardButton("Lista della spesa"));
        keyboard.add(line);
        line = new ArrayList<>();
        line.add(new KeyboardButton("Aggiungi"));
        line.add(new KeyboardButton("Rimuovi"));
        keyboard.add(line);
        ReplyKeyboardMarkupWithButtons replyKeyboard = new ReplyKeyboardMarkupWithButtons(keyboard);
        replyKeyboard.setResizeKeyboard(true);
        return replyKeyboard;
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

