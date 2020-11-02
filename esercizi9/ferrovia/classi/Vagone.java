package it.corsobackendtree.esercizi9.ferrovia.classi;

import java.util.ArrayList;

public abstract class Vagone {
    public static int counterIdVagone = 0;
    int id;
    int maxPasseggeri;
    ArrayList<Passeggero> passeggeri;
    ArrayList<Porta> porte;

    public Vagone(int maxPasseggeri, ArrayList<Porta> porte) {
        this.id = ++counterIdVagone;
        this.maxPasseggeri = maxPasseggeri;
        this.porte = porte;
    }

    public boolean isEmpty() {
        return passeggeri.size() == 0;
    }

    public int getNumPasseggeri(){
        return passeggeri.size();
    }

    public void apriPorte(){
        for(Porta p : porte){
            p.apriPorta();
        }
    }

    public void chiudiPorte(){
        for(Porta p : porte){
            p.chiudiPorta();
        }
    }

    public boolean entraPasseggero(Passeggero p) {
        if(id != p.idVagone){
            System.out.println("Il passeggero non può salire da questo vagone!");
            return false;
        }
        if (passeggeri.size() < maxPasseggeri) {
            for (Porta porta : porte) {
                if (porta.getStatoPorta() == Porta.StatoPorta.APERTA) {
                    return passeggeri.add(p);
                }
            }
            System.out.println("Porte chiuse! Il passeggero non può entrare.");
            return false;
        } else {
            System.out.println("Vagone pieno!");
            return false;
        }
    }

    public boolean escePasseggero(Passeggero p) {
        if (passeggeri.size() > 0) {
            for (Porta porta : porte) {
                if (porta.getStatoPorta() == Porta.StatoPorta.APERTA) {
                    if(passeggeri.remove(p)) return true;
                    else{
                        System.out.println("Passeggero non presente nel vagone!");
                        return false;
                    }
                }
            }
            System.out.println("Porte chiuse! Il passeggero non può uscire.");
            return false;
        }else{
            System.out.println("Non ci sono passeggeri!");
            return false;
        }
    }
}