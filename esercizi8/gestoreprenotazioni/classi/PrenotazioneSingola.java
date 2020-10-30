package it.corsobackendtree.esercizi8.gestoreprenotazioni.classi;

public class PrenotazioneSingola extends Prenotazione{
    private Preferenza preferenza;
    public PrenotazioneSingola(String codice, Preferenza preferenza){
        super(codice);
        this.preferenza = preferenza;
    }
    public Preferenza getPreferenza(){
        return preferenza;
    }
}
