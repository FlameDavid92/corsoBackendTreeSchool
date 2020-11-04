package it.corsobackendtree.esercizi9.ferrovia.classi.binari;

public class BinarioScambio extends Binario {
    Binario alternativo;
    public BinarioScambio(Binario successivo, Binario alternativo){
        super(successivo);
        this.alternativo = alternativo;
    }
    public void scambia(){
        Binario temp = this.successivo;
        this.successivo = alternativo;
        alternativo = temp;
    }
}
