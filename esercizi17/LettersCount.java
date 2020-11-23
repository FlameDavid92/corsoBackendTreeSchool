package it.corsobackendtree.esercizi17;

import java.util.stream.Stream;

public class LettersCount {
    public static void main(String[] args) {
        String[] nomi = {"Davide","Chiara","Fabio","Alessio","Francesca"};
        noStreamSol(nomi);
        System.out.println("--------");
        streamSol(nomi);
    }

    private static void noStreamSol(String[] nomi){
        long start = System.currentTimeMillis();
        int resp = 0;
        for(String nome : nomi){
            if(nome.charAt(0) == 'F' || nome.charAt(0) == 'f'){
                resp += nome.length();
            }
        }
        System.out.println("RESP: "+resp);
        System.out.println("JAVA7 time:"+(System.currentTimeMillis()-start));
    }

    private static void streamSol(String[] nomi){
        long start = System.currentTimeMillis();
        int resp = Stream.of(nomi).filter(nome -> nome.charAt(0) == 'F' || nome.charAt(0) == 'f')
                .mapToInt(String::length).sum();
        System.out.println("RESP: "+resp);
        System.out.println("JAVA8 time:"+(System.currentTimeMillis()-start));
    }
}
