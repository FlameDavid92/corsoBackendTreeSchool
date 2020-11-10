package it.corsobackendtree.esercizi13.dictionary.eccezioni;

public class VoidDictionaryException extends Exception {
    private static final long serialVersionUID = 2368606468236233276L;
    public VoidDictionaryException(String errorMessage){
        super(errorMessage);
    }
}
