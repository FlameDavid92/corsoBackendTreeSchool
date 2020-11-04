package botListaDellaSpesa;

import com.botticelli.bot.Bot;
import com.botticelli.bot.request.methods.MessageToSend;
import com.botticelli.bot.request.methods.types.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BotListaDellaSpesa extends Bot {
    public enum StatoUtenteBot {COMANDO, AGGIUNGI, RIMUOVI}

    Map<Long, ArrayList<ElementoLista>> listeSpesa;
    Map<Long, StatoUtenteBot> statoUtenti;

    public BotListaDellaSpesa(String token) {
        super(token);
        listeSpesa = new HashMap<>();
        statoUtenti = new HashMap<>();
    }

    @Override
    public void textMessage(Message message) {
        MessageToSend mts = null;
        ArrayList<ElementoLista> listaSpesaUtente;
        Long idUtente = message.getChat().getId();
        StatoUtenteBot statoUtente = (statoUtenti.get(message.getFrom().getId()) == null) ? StatoUtenteBot.COMANDO : statoUtenti.get(message.getFrom().getId());
        String testoInputUtente = message.getText();
        
        switch (statoUtente) {
            case COMANDO:
                ComandoBotSpesa c = ComandoBotSpesa.fromString(testoInputUtente);
                switch (c) {
                    case START:
                        mts = new MessageToSend(message.getFrom().getId(), benvenuto());
                        listeSpesa.put(message.getFrom().getId(), new ArrayList<>());
                        mts.setReplyMarkup(tastiera());
                        break;
                    case LISTA:
                        mts = new MessageToSend(idUtente, getStringLista(message.getFrom().getId()));
                        break;
                    case AGGIUNGI:
                        mts = new MessageToSend(idUtente, "Aggiungi un elemento alla lista inviando un messaggio nel formato di stringa <nomeprodotto>-<quantità>.");
                        mts.setReplyMarkup(new ReplyKeyboardRemove());
                        statoUtenti.put(idUtente,StatoUtenteBot.AGGIUNGI);
                        break;
                    case RIMUOVI:
                        if (listeSpesa.get(message.getFrom().getId()).size() > 0) {
                            mts = new MessageToSend(idUtente, "Inserisci l'indice dell'elemento che vuoi rimuovere.");
                            mts.setReplyMarkup(new ReplyKeyboardRemove());
                            statoUtenti.put(idUtente,StatoUtenteBot.RIMUOVI);
                        } else {
                            mts = new MessageToSend(idUtente, "La lista è vuota, non c'è niente da rimuovere!!!");
                        }
                        break;
                    case ERRORE:
                        mts = new MessageToSend(idUtente, "Input non riconosciuto!");
                }
                break;

            case AGGIUNGI:
                String[] splittedResp = testoInputUtente.split("-");
                listaSpesaUtente = listeSpesa.get(message.getFrom().getId());
                System.out.println(splittedResp[0].trim().equals(""));
                if(splittedResp.length > 1 ){
                    try{
                        listaSpesaUtente.add(new ElementoLista(splittedResp[0],Integer.parseInt(splittedResp[1])));
                        statoUtenti.put(idUtente,StatoUtenteBot.COMANDO);
                        mts = new MessageToSend(idUtente, "Elemento aggiunto!");
                        mts.setReplyMarkup(tastiera());
                    }catch(NumberFormatException e){
                        mts = new MessageToSend(idUtente, "Input non corretto!");
                        statoUtenti.put(idUtente,StatoUtenteBot.AGGIUNGI);
                    }
                }else{
                    listaSpesaUtente.add(new ElementoLista(splittedResp[0],1));
                    statoUtenti.put(idUtente,StatoUtenteBot.COMANDO);
                    mts = new MessageToSend(idUtente, "Elemento aggiunto!");
                    mts.setReplyMarkup(tastiera());
                }

                break;
            case RIMUOVI:
                listaSpesaUtente = listeSpesa.get(message.getFrom().getId());
                int indice = -1;
                try {
                    indice = Integer.parseInt(testoInputUtente);
                    if (indice == -1) {
                        mts.setReplyMarkup(tastiera());
                        statoUtenti.put(idUtente,StatoUtenteBot.COMANDO);
                    } else if (indice >= 0 && indice < listaSpesaUtente.size()) {
                        listaSpesaUtente.remove(indice);
                        mts = new MessageToSend(idUtente, "Elemento rimosso!");
                        mts.setReplyMarkup(tastiera());
                        statoUtenti.put(idUtente,StatoUtenteBot.COMANDO);
                    } else {
                        mts = new MessageToSend(idUtente, "Indice non corretto!");
                    }
                } catch (NumberFormatException e) {
                    mts = new MessageToSend(idUtente, "Input non riconosciuto!" +
                            "\nInserisci l'indice dell'elemento che vuoi rimuovere.");
                }
        }
        sendMessage(mts);
    }

    private String getStringLista(Long idUtente) {
        String ret = "";
        ArrayList<ElementoLista> listaSpesaUtente = listeSpesa.get(idUtente);
        ElementoLista tmp;
        if (listaSpesaUtente.size() > 0) {
            for (int i = 0; i < listaSpesaUtente.size(); i++) {
                tmp = listaSpesaUtente.get(i);
                ret += i + " " + tmp.getNome() + " " + tmp.getQuantita() + "\n";
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

    private String benvenuto(){
        return "Benvenuto, ora puoi gestire la tua lista cliccando su 'Aggiungi' o 'Rimuovi'." +
                "\nPuoi vedere gli elementi attualmente inseriti cliccando su 'Lista della spesa'.";
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

