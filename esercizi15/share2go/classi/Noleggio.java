package it.corsobackendtree.esercizi15.share2go.classi;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public class Noleggio {
    private UUID id;
    private Utente utente;
    private Vettura vettura;
    private Instant inizioNoleggio;
    private Instant fineNoleggio;
    private boolean terminato;
    private boolean pagato;

    public Noleggio(Utente utente, Vettura vettura){
        id = UUID.randomUUID();
        this.utente = utente;
        this.vettura = vettura;
        inizioNoleggio = Instant.now();
        terminato = false;
        pagato = false;
    }

    public UUID getId() {
        return id;
    }
    public Utente getUtente() {
        return utente;
    }
    public Vettura getVettura() {
        return vettura;
    }

    void terminaNoleggio(){
        fineNoleggio = Instant.now();
        terminato = true;
    }

    public Importo calcolaCosto(){
        Importo prezzoAlMinuto = vettura.getPrezzoAlMinuto();
        return new Importo(prezzoAlMinuto.getLocale(),prezzoAlMinuto.value.multiply(new BigDecimal(Math.ceil((fineNoleggio.getEpochSecond() - inizioNoleggio.getEpochSecond())/60.0))));
    }

    void paga(){
        utente.getCredito().spendi(calcolaCosto());
        pagato = true;
    }

    @Override
    public String toString() {
        return "Noleggio{"+id+"}"+" terminato:"+terminato+" pagato:"+pagato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Noleggio noleggio = (Noleggio) o;
        return Objects.equals(id, noleggio.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
