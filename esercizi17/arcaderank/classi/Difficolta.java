package it.corsobackendtree.esercizi17.arcaderank.classi;

public enum Difficolta {
    UNO(1),DUE(2),TRE(3),QUATTRO(4),CINQUE(5);
    int difficolta;
    private Difficolta(int difficolta){
        this.difficolta = difficolta;
    }
    public int getInt() {
        return difficolta;
    }
}
