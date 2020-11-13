package it.corsobackendtree.esercizi15.share2go.classi;

import java.math.BigDecimal;
import java.util.Locale;

public class Credito extends Importo{

    public Credito(Locale locale) {
        super(locale, new BigDecimal("0"));
    }

    boolean ricarica(Importo importo) {
        if (importo.getCurrency().equals(currency)) {
            this.value = this.value.add(importo.getValue());
            return true;
        } else{
            System.out.println("Errore valuta!");
            return false;
        }
    }

    boolean spendi(Importo importo) {
        if (importo.getCurrency().equals(currency)) {
            this.value = this.value.subtract(importo.getValue());
            return true;
        }else{
            System.out.println("Errore valuta!");
            return false;
        }
    }
}
