package it.corsobackendtree.esercizi15.share2go.classi;

import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;

public class App {
    HashMap<String, Utente> utenti;
    HashMap<String, Vettura> vetture;

    public App() {
        utenti = new HashMap<>();
        vetture = new HashMap<>();
    }

    public boolean inserisciVettura(String targa, Vettura.TipoVettura tipo, int postiDisponibili, double livelloDiCarburanteInPercent, Parcheggio parcheggio, Importo prezzoAlMinuto) {
        if (!vetture.containsKey(targa.toUpperCase())) {
            try {
                Vettura nuovaVettura = new Vettura(targa, tipo, postiDisponibili, livelloDiCarburanteInPercent, parcheggio, prezzoAlMinuto);
                vetture.put(nuovaVettura.getTarga().toString(), nuovaVettura);
                return true;
            } catch (MalformedTargaException e) {
                System.out.println("La targa inserita non è riconosciuta come targa italiana!");
                return false;
            }
        } else {
            System.out.println("Vettura già presente!");
            return false;
        }
    }

    public Vettura getVettura(String targa) {
        return vetture.get(targa.toUpperCase());
    }

    public boolean registraUtente(String email) {
        if (!utenti.containsKey(email.toLowerCase())) {
            try {
                Utente nuovoUtente = new Utente(email);
                utenti.put(nuovoUtente.getEmail().toString(), nuovoUtente);
                return true;
            } catch (MalformedEmailException e) {
                System.out.println("Formato dell'email non corretto, l'utente non è stato registrato!");
                return false;
            }
        } else {
            System.out.println("L'email fornita è stata già precedentemente registrata!");
            return false;
        }
    }

    public Utente getUtente(String email) {
        return utenti.get(email.toLowerCase());
    }

    public boolean noleggiaVettura(Utente utente, Vettura vettura) {
        if (utente.isNoleggioInCorso()) {
            System.out.println("L'utente ha già un noleggio in corso!");
            return false;
        }
        if (vettura.isNoleggiata()) {
            System.out.println("La vettura non è disponibile");
            return false;
        }
        utente.noleggiaVettura(vettura);
        return true;
    }

    public boolean parcheggiaVettura(Utente utente, Vettura vettura, Parcheggio parcheggio) {
        if (!utente.isNoleggioInCorso()) {
            System.out.println("L'utente non ha un noleggio in corso!");
            return false;
        }
        if (!utente.getNoleggioInCorso().getVettura().equals(vettura)) {
            System.out.println("La vettura fornita non è quella che l'utente ha noleggiato!");
            return false;
        }

        try {
            utente.parcheggiaVettura(utente.getNoleggioInCorso(), parcheggio);
            return true;
        } catch (ParcheggioPienoException e) {
            System.out.println("Parcheggio pieno!");
            return false;
        }
    }

    public List<Noleggio> getStoricoNoleggiEffettuati(Utente utente) {
        return utente.getNoleggiEffettuati();
    }

    public boolean ricarica(Utente utente, Importo importo) {
        return utente.getCredito().ricarica(importo);
    }

    public int getMaxMinutiNoleggio(Utente utente, Vettura vettura) {
        int nMaxMinuti = 0;
        Importo creditoUtente = utente.getCredito();
        Importo costoVetturaAlMinuto = vettura.getPrezzoAlMinuto();
        if (creditoUtente.currency == costoVetturaAlMinuto.currency) {
            return (int) creditoUtente.value.divide(costoVetturaAlMinuto.value,2, RoundingMode.FLOOR).doubleValue();
        } else {
            System.out.println("Valute differenti!!!");
            return -1;
        }
    }

    public void printStatoVetture(){
        Vettura temp;
        for(String targa : vetture.keySet()){
            temp = vetture.get(targa);
            System.out.println(temp.toString()+" "+temp.getStato());
        }
    }

    public void noleggioPagato(Noleggio noleggio){
        noleggio.paga();
    }
}
