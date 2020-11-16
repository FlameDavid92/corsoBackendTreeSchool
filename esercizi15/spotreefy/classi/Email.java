package it.corsobackendtree.esercizi15.spotreefy.classi;


import it.corsobackendtree.esercizi15.spotreefy.classi.eccezioni.MalformedEmailException;

import java.util.Objects;
import java.util.regex.Pattern;

public class Email {
    private String email;

    public Email(String email) throws MalformedEmailException {
        String lowEmail = email.toLowerCase();
        if(valuta(lowEmail)){
            this.email = lowEmail;
        }else{
            throw new MalformedEmailException();
        }
    }

    public boolean valuta(String email){
        /*semplice regex che controlla che sia presente la @ ed almeno un carattere prima e dopo della @*/
        String regex = "^(.+)@(.+)$";
        return Pattern.matches(regex,email);
    }

    @Override
    public String toString() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email1 = (Email) o;
        return Objects.equals(email, email1.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
