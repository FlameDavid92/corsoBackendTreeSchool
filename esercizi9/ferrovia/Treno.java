package it.corsobackendtree.esercizi9.ferrovia;

public abstract class Treno {
    private int codice;
    private double velocitaKmH;
    int numeroVagoni;
    int maxVagoni;
    int passeggeri;
    boolean fermo;
    boolean porteAperte;

    public Treno(int codice, double velocita, int maxVagoni) {
        this.codice = codice;
        this.velocitaKmH = velocita;
        this.numeroVagoni = 0;
        this.passeggeri = 0;
        this.maxVagoni = maxVagoni;
        this.fermo = false;
        this.porteAperte = false;
    }
    public void parti() {
        this.fermo = false;
        this.velocitaKmH = 80;
    }
    public void frena() {
        this.velocitaKmH = 0;
    }
    public void entraInStazione() {
        this.fermo = true;
    }
    public void aggiungiVagone() {
        if (numeroVagoni < maxVagoni) {
            this.numeroVagoni++;
        }else{
            System.out.println("Non puoi più aggiungere vagoni, " +
                    "hai raggiunto il limite massimo!");
        }
    }
    public void rimuoviVagone(){
        if (numeroVagoni > 0) {
            this.numeroVagoni--;
        }else{
            System.out.println("Non ci sono vagoni!");
        }
    }
    public void entraPasseggero() {
        if(porteAperte){
            this.passeggeri++;
        }else{
            System.out.println("Le porte sono chiuse, " +
                    "il passeggero non può entrare!");
        }
    }
    public void apriPorte() {
        this.porteAperte = true;
    }
    public void chiudiPorte() {
        this.porteAperte = false;
    }
}
