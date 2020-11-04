package it.corsobackendtree.esercizi10.labirinto2.classi;

public class Muro extends EntitaLabirinto{
    public Muro(int posX, int posY) {
        super(posX, posY);
    }
    @Override
    public String toString(){
        return "W";
    }
}
