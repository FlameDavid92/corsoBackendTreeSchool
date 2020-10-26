package it.corsobackendtree.esercizi6.numeriromani;

public enum SimboloRomano {
    M(1000), D(500), C(100), L(50), X(10), V(5), I(1);
    int n;

    SimboloRomano(int n) {
        this.n = n;
    }

    public int getInt() {
        return this.n;
    }
}
