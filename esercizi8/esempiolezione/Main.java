package it.corsobackendtree.esercizi8.esempiolezione;

import it.corsobackendtree.esercizi8.esempiolezione.classi.Persona;
import it.corsobackendtree.esercizi8.esempiolezione.classi.Professore;
import it.corsobackendtree.esercizi8.esempiolezione.classi.Studente;

public class Main {
    public static void main(String[] args){
        Persona persona = new Persona("Mario","Rossi");

        Studente studente1 = new Studente("1824563", "Mario", "Rossi");
        Studente studente2 = new Studente("1720502", "Carlo", "Verdi");
        Studente studente3 = new Studente("1824563","IoNonDovreiEsistere","CheCiFaccioQui");

        Professore professore1 = new Professore(1,"Mario","Rossi");
        Professore professore2 = new Professore(2,"Giovanni","Bianchi");

        String test = "test";

        System.out.println("TEST (ok se tutti true)");

        System.out.println(studente1.equals(studente1)); /* equals è riflessiva */
        System.out.println(!studente1.equals(null)); /* l'istanza di Studente NON è null */
        System.out.println(!studente1.equals(test)); /* l'istanza di Studente NON è della stessa classe dell'istanza di String */
        System.out.println(!studente1.equals(studente2)); /* i due studenti hanno matricola differente */
        System.out.println(studente1.equals(studente3)); /* i due studenti hanno la stessa matricola => quindi sono uguali! */

        System.out.println(!professore1.equals(persona)); /* l'istanza di Professore NON è della stessa classe dell'istanza di Persona */
        System.out.println(!professore1.equals(professore2)); /* i due professori hanno id differente */
        System.out.println(professore1.hashCode() != professore2.hashCode()); /* i due professori hanno id differente => viene generato un hashcode differente per le due istanze */
    }
}
