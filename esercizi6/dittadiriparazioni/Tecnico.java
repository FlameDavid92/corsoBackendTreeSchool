package it.corsobackendtree.esercizi6.dittadiriparazioni;

public class Tecnico {
    private String nome;
    private Riparazione incaricoAttuale;
    private boolean inFerie;
    public Tecnico(String nome){
        this.nome = nome;
        this.inFerie = false;
        this.incaricoAttuale = null;
    }

    public String getNome(){ return this.nome; }
    public void vaInFerie(){
        this.inFerie = true;
    }
    public void tornaDalleFerie(){
        this.inFerie = false;
    }
    public boolean isDisponibile(){
        return !this.inFerie && this.incaricoAttuale == null;
    }
    public Riparazione getIncaricoAttuale(){
        return this.incaricoAttuale;
    }

    protected void setIncaricoAttuale(Riparazione r){
        this.incaricoAttuale = r;
    }
    protected void concludiIncarico(){
        this.incaricoAttuale = null;
    }
}
