package it.corsobackendtree.esercizi9.ferrovia.classi;

public abstract class Binario {
    protected Binario successivo;
    protected Binario(Binario successivo) {
        this.successivo = successivo;
    }
    public Binario getSuccessivo(){
        return successivo;
    }
    public Binario percorri(Treno t){
        System.out.println("Il treno percorre il binario...");
        return getSuccessivo();
    }
}