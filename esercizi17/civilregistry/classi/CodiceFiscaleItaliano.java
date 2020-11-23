package it.corsobackendtree.esercizi17.civilregistry.classi;

import java.util.Objects;
import java.util.regex.Pattern;

public class CodiceFiscaleItaliano {
    private static String regex = "^[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]$";
    private String codice;

    public CodiceFiscaleItaliano(String codiceFiscale) throws Exception {
        if(checkValidity(codiceFiscale.toUpperCase())) this.codice = codiceFiscale.toUpperCase();
        else throw new Exception("Formato del codice fiscale non valido!");
    }

    private boolean checkValidity(String codiceFiscale){
        return Pattern.matches(regex, codiceFiscale);
    }

    public String getCodice() {
        return codice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodiceFiscaleItaliano that = (CodiceFiscaleItaliano) o;
        return Objects.equals(codice, that.codice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codice);
    }
}
