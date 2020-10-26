package it.corsobackendtree.esercizi6.numeriromani;

public class NumeroRomano {
    SimboloRomano[] cr;

    public NumeroRomano(String data) {
        cr = new SimboloRomano[data.length()];
        for (int i = 0; i < data.length(); i++) {
            switch (data.charAt(i)) {
                case 'M':
                    cr[i] = SimboloRomano.M;
                    break;
                case 'D':
                    cr[i] = SimboloRomano.D;
                    break;
                case 'C':
                    cr[i] = SimboloRomano.C;
                    break;
                case 'L':
                    cr[i] = SimboloRomano.L;
                    break;
                case 'X':
                    cr[i] = SimboloRomano.X;
                    break;
                case 'V':
                    cr[i] = SimboloRomano.V;
                    break;
                case 'I':
                    cr[i] = SimboloRomano.I;
            }
        }
    }

    public int getValore() {
        int risultato = 0;
        for (int i = 0; i < this.cr.length; i++) {
            if (i == cr.length - 1) {
                risultato = risultato + cr[i].getInt();
            } else if (cr[i].getInt() >= cr[i + 1].getInt()) {
                risultato = risultato + cr[i].getInt();
            } else {
                risultato = risultato + (cr[i + 1].getInt() - cr[i].getInt());
                i++;
            }
        }
        return risultato;
    }


}
