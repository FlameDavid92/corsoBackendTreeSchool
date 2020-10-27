package it.corsobackendtree.esercizi7.classificaseriea.classi;

public class Classifica {
    Squadra[] serieA;

    public Classifica(Squadra[] serieA) {
        this.serieA = serieA;
    }

    public void esitoPartita(Squadra squadraCasa, int golCasa,
                             Squadra squadraOspite, int golOspite) {
        if(golCasa > golOspite){
            squadraCasa.vittoria();
        }else if(golCasa == golOspite){
            squadraCasa.pareggio();
            squadraOspite.pareggio();
        }else{
            squadraOspite.vittoria();
        }
        if(golCasa > 0){
            squadraCasa.setGolFatti(golCasa);
            squadraOspite.setGolSubiti(golCasa);
        }
        if(golOspite > 0){
            squadraOspite.setGolFatti(golOspite);
            squadraCasa.setGolSubiti(golOspite);
        }
    }

    public void getClassifica(){

    }

    public Squadra getMiglioreAttacco(){
        /*Gestire parimerito!*/
        Squadra sq = null;
        for(int i=0; i<serieA.length; i++){
            if(sq == null) sq = this.serieA[i];
            if(sq.getGolFatti() < this.serieA[i].getGolFatti()){
                sq = this.serieA[i];
            }
        }
        return sq;
    }

    public Squadra getPeggiorDifesa(){
        /*Gestire parimerito!*/
        Squadra sq = null;
        for(int i=0; i<serieA.length; i++){
            if(sq == null) sq = this.serieA[i];
            if(sq.getGolSubiti() < this.serieA[i].getGolFatti()){
                sq = this.serieA[i];
            }
        }
        return sq;
    }
}
