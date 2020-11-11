package it.corsobackendtree.esercizi14;

@StudenteUniversitario(universita = UniversitaRomane.SAPIENZA)
public class Studente {
    String matricola;
    String nome;
    String cognome;

    public Studente(String matricola, String nome, String cognome){
        this.matricola = matricola;
        this.nome = nome;
        this.cognome = cognome;
    }
}
