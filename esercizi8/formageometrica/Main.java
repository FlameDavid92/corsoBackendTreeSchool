package it.corsobackendtree.esercizi8.formageometrica;

import it.corsobackendtree.esercizi8.formageometrica.classi.Quadrato;
import it.corsobackendtree.esercizi8.formageometrica.classi.Rettangolo;

public class Main {
    public static void main(String[] args){
        Quadrato quadrato = new Quadrato(5);
        Rettangolo rettangolo = new Rettangolo(5,6);
        System.out.println(
                "Tipo: "+quadrato.toString()+"\n" +
                "Lato: "+quadrato.getLato()+"\n"+
                "Perimetro: "+quadrato.getPerimeter()+"\n"+
                "Area: "+quadrato.getArea()+"\n"
        );
        System.out.println(
                "Tipo: "+rettangolo.toString()+"\n" +
                "Base: "+rettangolo.getBase()+"\n"+
                "Altezza: "+rettangolo.getAltezza()+"\n"+
                "Perimetro: "+rettangolo.getPerimeter()+"\n"+
                "Area: "+rettangolo.getArea()+"\n"
        );
    }
}
