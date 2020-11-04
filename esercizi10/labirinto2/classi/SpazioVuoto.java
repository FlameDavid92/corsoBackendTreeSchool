package it.corsobackendtree.esercizi10.labirinto2.classi;

public class SpazioVuoto extends EntitaLabirinto{
    public SpazioVuoto(int posX, int posY) {
        super(posX, posY);
    }
    @Override
    public String toString(){
        return "-";
    }
}
