package it.corsobackendtree.esercizi15.spotreefy.classi;

import java.util.*;
import java.util.stream.Collectors;

public class Utente {
    private String nome;
    private String email; //univoca
    private Deque<Brano.IdBrano> codaDiRiproduzione;
    private Map<Brano.IdBrano, Integer> braniAscoltati;
    private Set<String> utentiSeguiti;
    private HashMap<String, Playlist> playlistsUtente;

    Utente(String nome, String email) {
        this.email = email;
        this.nome = nome;
        codaDiRiproduzione = new ArrayDeque<>();
        braniAscoltati = new HashMap<>();
        utentiSeguiti = new HashSet<>();
        playlistsUtente = new HashMap<>();
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public List<String> getUtentiSeguiti() {
        return List.copyOf(utentiSeguiti);
    }

    public List<Playlist> getPlaylists() {
        return List.copyOf(playlistsUtente.values());
    }

    public Playlist getPlaylistUtente(String nomePlaylist, String emailRichiedente) {
        Playlist ret = playlistsUtente.getOrDefault(nomePlaylist, null);
        if (ret.canRead(emailRichiedente)) return ret;
        else {
            System.out.println("L'utente non può vedere una playlist che non gli è stata condivisa!");
            return null;
        }
    }

    public Integer getAscolti(Brano.IdBrano idBrano){
        return braniAscoltati.getOrDefault(idBrano,null);
    }

    public void addBranoInCoda(Brano.IdBrano idBrano) {
        codaDiRiproduzione.offerLast(idBrano);
    }

    public void addBranoInTesta(Brano.IdBrano idBrano) {
        codaDiRiproduzione.offerFirst(idBrano);
    }

    public Playlist creaPlaylist(String nomePlaylist) {
        if (!playlistsUtente.containsKey(nomePlaylist)) {
            Playlist nuovaPlaylist = new Playlist(email, nomePlaylist);
            playlistsUtente.put(nuovaPlaylist.getNome(), nuovaPlaylist);
            return nuovaPlaylist;
        } else {
            System.out.println("Nome playlist già presente, scegli un nome differente!");
            return null;
        }
    }

    public boolean rimuoviPlaylist(String nomePlaylist) {
        return playlistsUtente.remove(nomePlaylist) != null;
    }

    public void seguiUtente(String emailUtente) {
        if (!emailUtente.toLowerCase().equals(email)) {
            utentiSeguiti.add(emailUtente);
        }else{
            System.out.println("Un utente non può seguire sé stesso :P!");
        }
    }

    public List<Brano.IdBrano> getStorico(){
        return braniAscoltati.entrySet().stream()
                .sorted((a,b)->b.getValue()
                        .compareTo(a.getValue()))
                .map(e->e.getKey()).collect(Collectors.toList());
    }

    public Set<Brano.IdBrano> getBraniAscoltati() {
        return braniAscoltati.keySet();
    }

    Brano.IdBrano getProssimoBrano() {
        Brano.IdBrano id = codaDiRiproduzione.pollFirst();
        int n = braniAscoltati.getOrDefault(id, 0);
        braniAscoltati.put(id, n + 1);
        return id;
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
}
