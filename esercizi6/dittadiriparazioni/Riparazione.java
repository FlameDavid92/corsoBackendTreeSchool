package it.corsobackendtree.esercizi6.dittadiriparazioni;

public class Riparazione {
    private String indirizzo;
    private int priorita;
    private boolean conclusa;
    private Tecnico tecnico;

    public Riparazione(String indirizzo, int priorita){
        this.indirizzo = indirizzo;
        this.priorita = priorita;
        this.tecnico = null;
        this.conclusa = false;
    }
    public String getIndirizzo() {
        return this.indirizzo;
    }
    public int getPriorita() {
        return this.priorita;
    }
    public Tecnico getTecnico(){
        return this.tecnico;
    }
    public boolean isGestita(){
        return this.tecnico != null;
    }
    public boolean isConclusa(){
        return this.conclusa;
    }
    protected void assegnaTecnico(Tecnico tec){
        this.tecnico = tec;
    }
    protected void concludi(){
        this.conclusa = true;
    }
}
