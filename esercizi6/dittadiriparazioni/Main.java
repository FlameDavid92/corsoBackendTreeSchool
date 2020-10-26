package it.corsobackendtree.esercizi6.dittadiriparazioni;

public class Main {
    public static void main(String[] args){
        DittaRiparazioni ditRip = new DittaRiparazioni();
        for(int i=0; i<100; i++){
            ditRip.aggiungiTecnico(new Tecnico("Davide"+i));
        }
        for(int j=0; j<500; j++){
            ditRip.aggiungiRiparazione(new Riparazione("Indirizzo"+j,j));
        }
        ditRip.assegnaIncarico();
        ditRip.mandaInFerie(new String[]{"Davide1","Davide2","Davide3"});
        ditRip.assegnaIncarico();
    }
}
