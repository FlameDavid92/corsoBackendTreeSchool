package it.corsobackendtree.esercizi15.spotreefy.classi;

import it.corsobackendtree.esercizi15.spotreefy.classi.eccezioni.AccessDeniedException;

import java.util.*;

public class Playlist {
    private String emailProprietario;
    private String nome;
    private Set<Brano.IdBrano> brani;
    private Set<String> utentiCondivisione;
    private long puntiDiRilevanza;

    Playlist(String emailProprietario, String nome){
        this.emailProprietario = emailProprietario;
        this.nome = nome;
        brani = new LinkedHashSet<>();
        utentiCondivisione = new HashSet<>();
        puntiDiRilevanza = 0;
    }

    public String getNome() {
        return nome;
    }

    public boolean canRead(String emailUtente){
        return emailUtente.equals(emailProprietario) || utentiCondivisione.contains(emailUtente);
    }

    public String getEmailProprietario() {
        return emailProprietario;
    }

    public List<Brano.IdBrano> getBrani(){
        return List.copyOf(brani);
    }

    public boolean containsBrano(Brano.IdBrano  idBrano){
        return brani.contains(idBrano);
    }

    public void aggiungiBrano(Utente proprietario, Brano.IdBrano idBrano){
        if(proprietario.getEmail().equals(emailProprietario)){
            brani.add(idBrano);
        }else{
            System.out.println("Solo l'utente proprietario può aggiungere brani alla playlist!");
        }
    }

    public void rimuoviBrano(Utente proprietario, Brano.IdBrano idBrano){
        if(proprietario.getEmail().equals(emailProprietario)){
            brani.remove(idBrano);
        }else{
            System.out.println("Solo l'utente proprietario può rimuovere brani dalla playlist!");
        }
    }

    public boolean aggiungiCondivisione(Utente proprietario, String emailUtenteCondivisione){
        if(proprietario.getEmail().equals(emailProprietario)){
            utentiCondivisione.add(emailUtenteCondivisione);
            return true;
        }else{
            System.out.println("Per condividere la playlist devi esserne il proprietario!");
            return false;
        }
    }
    public boolean rimuoviCondivisione(Utente proprietario, String emailUtenteCondivisione){
        if(proprietario.getEmail().equals(emailProprietario)){
            utentiCondivisione.remove(emailUtenteCondivisione);
            return true;
        }else {
            System.out.println("Per rimuovere la playlist devi esserne il proprietario!");
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Playlist playlist = (Playlist) o;
        return Objects.equals(nome, playlist.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
