package it.corsobackendtree.esercizi15.share2go.classi;

import java.util.Objects;

public class Vettura {
    public enum TipoVettura {AUTOMOBILE, FURGONE}

    private TipoVettura tipo;
    private TargaItaliana targa;
    private int postiDisponibili;
    private double livelloDiCarburanteInPercent;
    private Importo prezzoAlMinuto;
    private boolean noleggiata;
    private Parcheggio ultimoParcheggio;

    Vettura(String targa, TipoVettura tipo, int postiDisponibili, double livelloDiCarburanteInPercent, Parcheggio parcheggio, Importo prezzoAlMinuto) throws MalformedTargaException {
        this.targa = new TargaItaliana(targa);
        this.tipo = tipo;
        this.postiDisponibili = postiDisponibili;
        this.livelloDiCarburanteInPercent = livelloDiCarburanteInPercent;
        this.prezzoAlMinuto = prezzoAlMinuto;
        noleggiata = false;
        ultimoParcheggio = parcheggio;
    }

    public TargaItaliana getTarga() {
        return targa;
    }

    public Importo getPrezzoAlMinuto() {
        return prezzoAlMinuto;
    }

    public Parcheggio getUltimoParcheggio() {
        return ultimoParcheggio;
    }

    public boolean isNoleggiata() {
        return noleggiata;
    }

    void noleggia() {
        noleggiata = true;
    }

    void parcheggia(Parcheggio parcheggio) {
        ultimoParcheggio = parcheggio;
        noleggiata = false;
    }

    public String getStato() {
        if (isNoleggiata()) {
            return "Noleggio in corso";
        } else {
            if (ultimoParcheggio != null) {
                return "Posizione: " + "lat=" + ultimoParcheggio.getLatitudine() + " long=" + ultimoParcheggio.getLongitudine();
            }else{
                return "Mai noleggiata!";
            }
        }
    }

    @Override
    public String toString() {
        return "Vettura{"+targa+"}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vettura vettura = (Vettura) o;
        return Objects.equals(targa, vettura.targa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(targa);
    }
}
