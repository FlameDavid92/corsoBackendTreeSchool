package it.corsobackendtree.esercizi15.share2go.classi;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;
import java.util.Locale;

public class Importo {
    protected Locale locale;
    protected Currency currency;
    protected BigDecimal value;

    public Importo(Locale locale, BigDecimal importo){
        this.locale = locale;
        currency = Currency.getInstance(locale);
        value = importo;
    }

    public Locale getLocale() {
        return locale;
    }
    public Currency getCurrency() {
        return currency;
    }
    public BigDecimal getValue() {
        return value.setScale(2, RoundingMode.FLOOR);
    }
}
