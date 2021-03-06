package it.corsobackendtree.esercizi9.ferrovia.classi.passeggeri;

public abstract class Passeggero {
    private String nome;
    private String codiceBiglietto;
    private int idVagone;
    protected int idStazioneArrivo;
    protected Passeggero(String nome, String codiceBiglietto, int idVagone, int idStazioneArrivo){
        this.nome = nome;
        this.codiceBiglietto = codiceBiglietto;
        this.idVagone = idVagone;
        this.idStazioneArrivo = idStazioneArrivo;
    }
    public String getCodiceBiglietto() {
        return codiceBiglietto;
    }
    public String getNome() {
        return nome;
    }
    public int getIdVagone() {
        return idVagone;
    }
    public int getIdStazioneArrivo() {
        return idStazioneArrivo;
    }
}
