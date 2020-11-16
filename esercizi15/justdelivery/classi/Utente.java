package it.corsobackendtree.esercizi15.justdelivery.classi;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Utente {
    private String email;
    private String nome;
    private String cognome;
    private Set<Ordine> storicoOrdini;

    Utente(String email, String nome, String cognome) throws Exception {
        if(validaEmail(email)){
            this.email = email.toLowerCase();
            this.nome = nome;
            this.cognome = cognome;
            storicoOrdini = new LinkedHashSet<>();
        }else{
            throw new Exception("Formato email non valido, utente non creato!");
        }
    }

    private boolean validaEmail(String email){
        String regex = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+" +
                "(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)" +
                "*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")" +
                "@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|" +
                "\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}" +
                "(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:" +
                "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
        return Pattern.matches(regex,email);
    }

    public String getEmail() {
        return email;
    }
    public String getNome() {
        return nome;
    }
    public String getCognome() {
        return cognome;
    }

    public Set<Ordine> getStoricoOrdini() {
        return Set.copyOf(storicoOrdini);
    }

    public Ordine creaOrdine(Ristorante ristorante){
        Ordine nuovoOrdine = new Ordine(email, ristorante);
        storicoOrdini.add(nuovoOrdine);
        return nuovoOrdine;
    }

    public Set<String> ristorantiOrdini(){
        HashSet<String> ret = new HashSet<>();
        storicoOrdini.stream().forEach(o -> ret.add(o.getRistorante().getNome()));
        return ret;
    }

    public Map<String,Integer> getMyPrefRestaurant(){
        HashMap<String,Integer> myPrefRestaurant = new HashMap<>();
        storicoOrdini.stream().forEach(o -> {
            myPrefRestaurant.put(o.getRistorante().getNome(), myPrefRestaurant.getOrDefault(o.getRistorante().getNome(),0)+1);
        });
        LinkedHashMap<String,Integer> sortedMyPrefRestaurant = new LinkedHashMap<>();
        myPrefRestaurant.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(es->sortedMyPrefRestaurant.put(es.getKey(),es.getValue()));
        return sortedMyPrefRestaurant;
    }

    public Ristorante.TipoCucina getPrefTipoCucina(){
        HashMap<Ristorante.TipoCucina,Integer> countPrefTipi = new HashMap<>();
        storicoOrdini.stream().forEach(o -> {
            countPrefTipi.put(o.getRistorante().getTipoCucina(),countPrefTipi.getOrDefault(o.getRistorante().getTipoCucina(),0)+1);
        });
        Optional<Map.Entry<Ristorante.TipoCucina,Integer>> opt = countPrefTipi.entrySet().stream().max(Map.Entry.comparingByValue());
        if(opt.isPresent()){
            return opt.get().getKey();
        }else{
            return null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utente utente = (Utente) o;
        return Objects.equals(email, utente.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return "Utente{" + email + " " + nome + " " + cognome +"}";
    }
}
