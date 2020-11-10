package it.corsobackendtree.esercizi13.dictionary.eccezioni;
public class MalformedSignificatoException extends Exception {
    private static final long serialVersionUID = 7686289474465330543L;

    public MalformedSignificatoException(String errorMessage) {
        super(errorMessage);
    }
}
