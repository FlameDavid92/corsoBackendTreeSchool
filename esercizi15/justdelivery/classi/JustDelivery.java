package it.corsobackendtree.esercizi15.justdelivery.classi;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class JustDelivery {
    public static JustDelivery instance = null;
    private Map<String,Utente> utenti;
    private Map<String,Ristorante> ristoranti;

    public static JustDelivery getInstance() {
        if(instance == null) instance = new JustDelivery();
        return instance;
    }

    private JustDelivery(){
        utenti = new HashMap<>();
        ristoranti = new HashMap<>();
    }

    public Utente registraUtente(String email, String nome, String cognome){
        if(!utenti.containsKey(email.toLowerCase())){
            try {
                Utente nuovoUtente = new Utente(email,nome,cognome);
                utenti.put(nuovoUtente.getEmail(),nuovoUtente);
                return nuovoUtente;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            }
        }else{
            System.out.println("Utente già iscritto!");
            return utenti.get(email.toLowerCase());
        }
    }

    public Ristorante registraRistorante(String nome, Ristorante.TipoCucina tipoCucina, double speseConsegna){
        if(!ristoranti.containsKey(nome.toLowerCase())){
            Ristorante nuovoRisto = new Ristorante(nome, tipoCucina, speseConsegna);
            ristoranti.put(nome.toLowerCase(),nuovoRisto);
            return nuovoRisto;
        }else{
            System.out.println("Ristorante già registrato!");
            return ristoranti.get(nome.toLowerCase());
        }
    }

    public Set<Ristorante> getRistorantiPerCucina(Ristorante.TipoCucina tipoCucina){
        return ristoranti.values().stream().filter(r->r.getTipoCucina().equals(tipoCucina)).collect(Collectors.toSet());
    }

    public Ristorante getNewRistoranteOfPrefType(Utente utente){
        Ristorante.TipoCucina tipoPreferito = utente.getPrefTipoCucina();
        for(Ristorante risto : ristoranti.values()){
            if(risto.getTipoCucina().equals(tipoPreferito) && !utente.ristorantiOrdini().contains(risto.getNome())){
                return risto;
            }
        }
        return null;
    }
}
