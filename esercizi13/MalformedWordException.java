package it.corsobackendtree.esercizi13;

public class MalformedWordException extends Exception {
    private static final long serialVersionUID = -5512837322538635858L;

    public MalformedWordException(String errorMessage){
        super(errorMessage);
    }
}
