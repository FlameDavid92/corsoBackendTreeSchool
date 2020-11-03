package it.corsobackendtree.esercizi10.miniAmazon.classi;

public class ProdottoFisico extends Prodotto {
    private double peso;
    private double volume;
    private int quantitaDisponibile;

    public ProdottoFisico(String nome, double prezzo, double peso, double volume, int quantitaDisponibile) {
        super(nome, prezzo);
        this.peso = peso;
        this.volume = volume;
        this.quantitaDisponibile = quantitaDisponibile;
    }

    public int getQuantitaDisponibile() {
        return quantitaDisponibile;
    }

    @Override
    public void acquista() {
        if (quantitaDisponibile > 0) {
            this.quantitaDisponibile--;
            super.acquista();
        }
    }
}
