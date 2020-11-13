package it.corsobackendtree.esercizi15.share2go.classi;

import java.math.BigDecimal;
import java.util.*;

public class Utente {
    private Email email;
    private Credito credito;
    private Noleggio noleggioInCorso;
    private Set<Noleggio> noleggiEffettuati;

    Utente(String email) throws MalformedEmailException {
        this.email = new Email(email);
        this.credito = new Credito(Locale.ITALY);
        noleggioInCorso = null;
        noleggiEffettuati = new LinkedHashSet<>();
    }

    public Email getEmail() {
        return email;
    }

    public Credito getCredito() {
        return credito;
    }

    public boolean isNoleggioInCorso() {
        return noleggioInCorso != null;
    }

    public Noleggio getNoleggioInCorso() {
        return noleggioInCorso;
    }

    public List<Noleggio> getNoleggiEffettuati() {
        return List.copyOf(noleggiEffettuati);
    }

    Noleggio noleggiaVettura(Vettura vettura){
        Noleggio nuovoNoleggio = new Noleggio(this,vettura);
        if(vettura.getUltimoParcheggio() instanceof ParcheggioConvenzionato){
            ((ParcheggioConvenzionato) vettura.getUltimoParcheggio()).esceVettura();
        }
        vettura.noleggia();
        noleggioInCorso = nuovoNoleggio;
        return nuovoNoleggio;
    }

    boolean parcheggiaVettura(Noleggio noleggio, Parcheggio parcheggio) throws ParcheggioPienoException {
        if(parcheggio instanceof ParcheggioConvenzionato){
            if(!((ParcheggioConvenzionato)parcheggio).parcheggiaVettura()){
                throw new ParcheggioPienoException();
            }
        }
        noleggiEffettuati.add(noleggio);
        noleggio.getVettura().parcheggia(parcheggio);
        noleggio.terminaNoleggio();
        return true;
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
