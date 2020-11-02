package it.corsobackendtree.esercizi9.iterabile;

public abstract class IterabileAbstract implements Iterabile{
    int currentIndex;
    public IterabileAbstract(){
        this.currentIndex = 0;
    }
    @Override
    public void reset() {
        this.currentIndex = 0;
    }
}
