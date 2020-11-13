package it.corsobackendtree.esercizi15.share2go.classi;

public class ParcheggioConvenzionato extends Parcheggio {
    int massimoNPosti;
    int postiOccupati;

    public ParcheggioConvenzionato(double latitudine, double longitudine, int massimoNPosti) {
        super(latitudine, longitudine);
        this.massimoNPosti = massimoNPosti;
        postiOccupati = 0;
    }

    public boolean isFull() {
        return postiOccupati == massimoNPosti;
    }

    public int getPostiOccupati() {
        return postiOccupati;
    }

    boolean parcheggiaVettura() {
        if(isFull()) {
            System.out.println("Parcheggio pieno!");
            return false;
        }
        else {
            postiOccupati++;
            return true;
        }
    }

    boolean esceVettura() {
        if (postiOccupati == 0) {
            System.out.println("Non ci sono vetture!");
            return false;
        } else {
            postiOccupati--;
            return true;
        }
    }
}
