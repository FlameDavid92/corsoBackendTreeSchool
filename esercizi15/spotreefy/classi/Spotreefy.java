package it.corsobackendtree.esercizi15.spotreefy.classi;

import it.corsobackendtree.esercizi15.spotreefy.classi.eccezioni.AccessDeniedException;
import it.corsobackendtree.esercizi15.spotreefy.classi.eccezioni.MalformedEmailException;

import java.util.*;
import java.util.stream.Collectors;

public class Spotreefy {
    private static Spotreefy instance = null;
    private Map<String, Utente> utenti;
    private Map<Brano.IdBrano, Brano> brani;

    public static Spotreefy getInstance() {
        if (instance == null) {
            instance = new Spotreefy();
        }
        return instance;
    }

    private Spotreefy() {
        utenti = new HashMap<>();
        brani = new HashMap<>();
    }

    public Brano aggiungiBrano(UUID idAutore, String titolo, String genere) {
        if (!brani.containsKey(new Brano.IdBrano(idAutore, titolo))) {
            Brano nuovoBrano = new Brano(idAutore, titolo, genere);
            brani.put(nuovoBrano.getIdBrano(), nuovoBrano);
            return nuovoBrano;
        } else {
            System.out.println("Brano già presente in Spootreefy!");
            return null;
        }
    }

    public Brano getBrano(Brano.IdBrano idBrano) {
        return brani.getOrDefault(idBrano, null);
    }

    public Utente registraUtente(String nome, String email) {
        try {
            Email myEmail = new Email(email);
            Utente nuovoUtente = new Utente(nome, myEmail.toString());
            utenti.put(nuovoUtente.getEmail(), nuovoUtente);
            return nuovoUtente;
        } catch (MalformedEmailException e) {
            System.out.println("Formato email non riconosciuto, utente non registrato!");
            return null;
        }
    }

    public Utente getUtente(String emailUtente) {
        return utenti.getOrDefault(emailUtente.toLowerCase(), null);
    }

    public Brano getProssimoBrano(Utente utente) {
        Brano.IdBrano idBrano = utente.getProssimoBrano();
        getBrano(idBrano).ascolta();
        return getBrano(idBrano);
    }

    public Playlist getPlaylistPiuAscoltata() {
        long ret = 0;
        Playlist plToRet = null;

        long temp;
        for (Utente ut : utenti.values()) {
            for (Playlist pl : ut.getPlaylists()) {
                temp = calcolaAscoltiPlaylist(pl);
                if (temp > ret) {
                    ret = temp;
                    plToRet = pl;
                }
            }
        }
        return plToRet;
    }

    public long calcolaAscoltiPlaylist(Playlist playlist) {
        return playlist.getBrani().stream()
                .map(e -> getBrano(e).getAscolti())
                .reduce(0L, (subtotal, element) -> subtotal + element);
    }

    public List<Brano> discover(Utente utente, int k) {
        return brani.values().stream()
                .filter(brano -> !utente.getBraniAscoltati().contains(brano.getIdBrano()))
                .filter(brano -> {
                    for (String email : utente.getUtentiSeguiti()) {
                        for (Playlist pl : getUtente(email).getPlaylists()) {
                            if (pl.containsBrano(brano.getIdBrano())) return true;
                        }
                    }
                    return false;
                }).limit(k).collect(Collectors.toList()); /*?domandeee*/
    }

    /*RECOMMENDATION1 ---- */

    /*RECOMMENDATION2 - !?!*/
    public Collection<Playlist> recommendation2(Utente utente, int k) {
        /*Per ora considero solo le playlist dell'utente!*/
        TreeMap<Integer, Playlist> retPl = new TreeMap<>();
        Set<Brano.IdBrano> braniAscoltati = utente.getBraniAscoltati();

        int temp;
        for (Playlist pl : utente.getPlaylists()) {
            temp = 0;
            for (Brano.IdBrano idBrano : pl.getBrani()) {
                if (braniAscoltati.contains(idBrano)) {
                    temp += utente.getAscolti(idBrano);
                }
            }
            if (retPl.size() < k) {
                retPl.put(temp, pl);
            }else{
                if(temp>retPl.firstKey()){
                    retPl.pollFirstEntry();
                    retPl.put(temp, pl);
                }
            }
        }
        return retPl.values();
    }

    /*
     * Discover: dato un utente u e un intero k > 0,
     * voglio ottenere k brani che non sono mai stati ascoltati dall'utente u
     * che però compaiono in almeno una playlist di un utente seguito dall'utente u
     *
     * Recommendation: dato un utente u e un intero k,
     * voglio ottenere le k playlist più rilevanti per l'utente u.
     * Ogni playlist deve avere un "punteggio" di rilevanza: una playlist ottiene 1 punto di "rilevanza"
     * per ogni brano contenuto in essa che è stato ascoltato dall'utente u. Non vanno considerate le playlist create dall'utente u.
     *
     * Recommendation++: cambiare il calcolo del punteggio di rilevanza,
     * un brano ascoltato dall'utente u vale tanti punti di rilevanza quante volte è stato ascoltato dall'utente u.
     *
     */

}
