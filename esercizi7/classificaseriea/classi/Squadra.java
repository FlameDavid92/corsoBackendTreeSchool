package it.corsobackendtree.esercizi7.classificaseriea.classi;

public class Squadra {
    private static int idCounter = 0;
    private int id;
    private String nome;
    private Giocatore[] rosaGiocatori;
    private int punteggio;
    private int golFatti;
    private int golSubiti;

    public Squadra(String nome, Giocatore[] rosaGiocatori){
        this.id = idCounter++;
        this.nome = nome;
        this.rosaGiocatori = rosaGiocatori;
        this.punteggio = 0;
        this.golFatti = 0;
        this.golSubiti = 0;
    }

    public int getId() { return this.id; }
    public String getNome() { return this.nome; }
    public int getPunteggio() {
        return punteggio;
    }
    protected void vittoria() {
        this.punteggio += 3;
    }
    protected void pareggio() { this.punteggio++; }
    public int getGolFatti() {
        return golFatti;
    }
    protected void setGolFatti(int golFatti) {
        this.golFatti += golFatti;
    }
    public int getGolSubiti() {
        return golSubiti;
    }
    protected void setGolSubiti(int golSubiti) {
        this.golSubiti += golSubiti;
    }

    @Override
    public String toString(){
        return this.nome+"  punti:"+this.punteggio+"  gol fatti:"+this.getGolFatti()+"  gol subiti:"+this.getGolSubiti();
    }
}
