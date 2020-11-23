package it.corsobackendtree.esercizi17.arcaderank.classi;

import java.util.*;
import java.util.stream.Collectors;

public class ArcadeRank {
    private static ArcadeRank instance = null;
    private final HashMap<UUID,Utente> utenti;
    private final HashMap<UUID,Videogioco> videogiochi;
    private final LinkedList<Partita> partite;

    /* È una ripetizione di dati evitabile poiché potrebbe essere ricalcolata ogni volta dalle singole classifiche dei videogiochi,
    * ma la volevo fare così :P */
    private final Map<UUID,Integer> punteggiGenerali;

    public static ArcadeRank getInstance(){
        if(instance == null) instance = new ArcadeRank();
        return instance;
    }

    private ArcadeRank(){
        utenti = new HashMap<>();
        videogiochi = new HashMap<>();
        punteggiGenerali = new HashMap<>();
        partite = new LinkedList<>();
    }

    public Utente inserisciUtente(String username){
        Utente nuovoUtente = new Utente(username);
        utenti.put(nuovoUtente.getId(),nuovoUtente);
        punteggiGenerali.put(nuovoUtente.getId(),0);
        return nuovoUtente;
    }

    public Utente getUtente(UUID idUtente){
        return utenti.get(idUtente);
    }

    public Videogioco inserisciVideogioco(String nome, Difficolta difficolta){
        Videogioco nuovoVideogioco = new Videogioco(nome, difficolta);
        videogiochi.put(nuovoVideogioco.getId(),nuovoVideogioco);
        return nuovoVideogioco;
    }

    public Videogioco getVideogioco(UUID idVideogioco){
        return videogiochi.get(idVideogioco);
    }

    public boolean inserisciPartita(UUID idUtente, UUID idVideogioco, int punteggio){
        Utente utente = utenti.getOrDefault(idUtente,null);
        Videogioco videogioco = videogiochi.getOrDefault(idVideogioco,null);
        if(utente != null && videogioco != null){
            Integer[] puntiArr = videogioco.inserisciPunteggio(idUtente, punteggio);
            if(puntiArr != null){
                /*aggiorna classifica generale*/
                punteggiGenerali.put(idUtente, (punteggiGenerali.get(idUtente) - puntiArr[0]) + puntiArr[1]);
            }
            partite.addFirst(new Partita(idUtente,idVideogioco,punteggio));
            return false; /*Il punteggio ottenuto in questa partita non è il migliore ottenuto dall'utente!*/
        }else{
            System.out.println("Utente o videogioco non presenti!");
            return false;
        }
    }

    public List<Partita> getUltimeNPartite(int n){
        return partite.stream().limit(n).collect(Collectors.toList());
    }

    public void printClassificaVideogioco(UUID idVideogioco){
        Videogioco videogioco = videogiochi.getOrDefault(idVideogioco,null);
        if(videogioco != null){
            videogioco.getClassifica().forEach(item -> {
                System.out.println(utenti.get(item.getIdUtente()).getUsername()+":"+item.getPunteggio());
            });
        }
    }

    public void printClassificaGenerale(){
        getClassificaGenerale().forEach(item -> {
            System.out.println(utenti.get(item.getIdUtente()).getUsername()+":"+item.getPunteggio());
        });
    }

    private List<ClassificaItem> getClassificaGenerale(){
        return punteggiGenerali.entrySet().stream().sorted((a,b) -> b.getValue().compareTo(a.getValue()))
                .limit(3).map(e -> new ClassificaItem(e.getKey(),e.getValue())).collect(Collectors.toList());
    }

    /*Senza utilizzare la mappa punteggiGenerali*/
    /*public void printClassificaGenerale2(){
        utenti.values().stream().flatMap(u -> videogiochi.values().stream().reduce(0,(a,b)-> a.))
    }*/
}
