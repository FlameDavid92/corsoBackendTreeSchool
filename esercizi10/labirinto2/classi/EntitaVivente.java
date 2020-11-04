package it.corsobackendtree.esercizi10.labirinto2.classi;

public class EntitaVivente extends EntitaLabirinto{
    public EntitaVivente(int posX, int posY) {
        super(posX, posY);
    }
    public void posXplus(){
        this.posX += 1;
    }
    public void posXminus(){
        this.posX -= 1;
    }
    public void posYplus(){
        this.posY += 1;
    }
    public void posYminus(){
        this.posY -= 1;
    }

    public void setPosX(int posX){
        this.posX = posX;
    }
    public void setPosY(int posY){
        this.posY = posY;
    }
}
