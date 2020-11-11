package it.corsobackendtree.esercizi14.bibilioteca2.classi;

import java.util.*;

public class Biblioteca {
    private HashMap<String,Libro> archivioLibriPerTitolo;
    private HashMap<UUID,Libro> archivioLibriPerCodice;
    private HashMap<UUID,Autore> autori;

    public Biblioteca() {
        archivioLibriPerTitolo = new HashMap<>();
        archivioLibriPerCodice = new HashMap<>();
        autori = new HashMap<>();
    }

    public Autore registraAutore(String nome, String cognome) {
        /*È possibile registrare più autori con stesso nome e cognome :P*/
        Autore nuovoAutore = new Autore(nome, cognome);
        autori.put(nuovoAutore.getId(),nuovoAutore);
        return nuovoAutore;
    }
    public Autore getAutore(UUID idAutore){
        return autori.get(idAutore);
    }
    public Libro getLibro(UUID codice) {
        return archivioLibriPerCodice.get(codice);
    }
    public Libro getLibro(String titolo) {
        return archivioLibriPerTitolo.get(titolo.toLowerCase());
    }
    public List<Libro> getLibri(Autore autore) {
        return autore.getLibriScritti();
    }
    public void printLibri(Autore autore){
        autore.printLibri();
    }
    public Libro inserisciLibro(String titolo, String sinossi, Autore autore) {
        if (getLibro(titolo) != null) return null;
        Libro nuovoLibro = new Libro(titolo, sinossi, autore);
        archivioLibriPerCodice.put(nuovoLibro.getCodice(),nuovoLibro);
        archivioLibriPerTitolo.put(titolo.toLowerCase(),nuovoLibro);
        autore.inserisciLibro(nuovoLibro);
        return nuovoLibro;
    }
    public boolean rimuoviLibro(UUID codice) {
        Libro toRet = archivioLibriPerCodice.remove(codice);
        if(toRet != null){
            archivioLibriPerTitolo.remove(toRet.getTitolo().toLowerCase());
            return true;
        }else return false;
    }
    public boolean rimuoviLibro(String titolo) {
        Libro toRet = archivioLibriPerTitolo.remove(titolo.toLowerCase());
        if(toRet != null){
            archivioLibriPerCodice.remove(toRet.getCodice());
            return true;
        }else return false;
    }
}
