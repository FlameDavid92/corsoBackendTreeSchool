package it.corsobackendtree.esercizi8.gestoreveicoli;

import it.corsobackendtree.esercizi8.gestoreveicoli.classi.Autocarro;
import it.corsobackendtree.esercizi8.gestoreveicoli.classi.Automobile;

public class Main {
    public static void main(String[] args){
        Automobile automobile = new Automobile("cf123rm", 4, 4);
        Autocarro autocarro = new Autocarro("ca133sm", 4, 2);
        System.out.println(
                "Automobile:\n"+
                "  targa = "+automobile.getTarga()+"\n"+
                "  numeroPorte = "+automobile.getNumeroPorte()+"\n"+
                "  numeroPosti = "+automobile.getNumeroPosti()
        );
        System.out.println(
                "Autocarro:\n"+
                        "  targa = "+autocarro.getTarga()+"\n"+
                        "  capacitaMassimaInQuintali = "+autocarro.getCapacitaMassimaInQuintali()+"\n"+
                        "  numeroPosti = "+autocarro.getNumeroPosti()
        );
    }
}
