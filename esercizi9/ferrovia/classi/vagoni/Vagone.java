package it.corsobackendtree.esercizi9.ferrovia.classi.vagoni;

import it.corsobackendtree.esercizi9.ferrovia.classi.passeggeri.Passeggero;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Vagone {
    public static int counterIdVagone = 0;
    private int id;
    private int maxPasseggeri;
    private ArrayList<Porta> porte;
    private ArrayList<Passeggero> passeggeri;

    public Vagone(int maxPasseggeri, ArrayList<Porta> porte) {
        this.id = ++counterIdVagone;
        this.maxPasseggeri = maxPasseggeri;
        this.porte = porte;
        this.passeggeri = new ArrayList<>();
    }

    public boolean isEmpty() {
        return passeggeri.size() == 0;
    }

    public int getId(){
        return id;
    }

    public int getNumPasseggeri(){
        return passeggeri.size();
    }

    public ArrayList<Passeggero> getPasseggeri() {
        return passeggeri;
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
        if(id != p.getIdVagone()){
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
            boolean check = false;
            for (Iterator<Porta> iterator = porte.iterator(); iterator.hasNext();) {
                Porta porta = iterator.next();
                if (porta.getStatoPorta() == Porta.StatoPorta.APERTA) {
                    check = true;
                    break;
                }
            }
            if(check){
                System.out.println("Il passeggero "+p.getNome()+" è sceso.");
                passeggeri.remove(p);
                return true;
            }
            else{
                System.out.println("Porte chiuse! Il passeggero non può uscire.");
                return false;
            }
        }else{
            System.out.println("Non ci sono passeggeri!");
            return false;
        }
    }

    public static class Porta {
        public enum StatoPorta {
            APERTA,CHIUSA,GUASTA
        }
        private StatoPorta statoPorta;

        public Porta(){
            this.statoPorta = StatoPorta.CHIUSA;
        }

        public void apriPorta() {
            if (statoPorta != StatoPorta.GUASTA) {
                statoPorta = StatoPorta.APERTA;
            }else{
                System.out.println("La porta è guasta");
            }
        }
        public void chiudiPorta() {
            if (statoPorta != StatoPorta.GUASTA) {
                statoPorta = StatoPorta.CHIUSA;
            }else{
                System.out.println("La porta è guasta");
            }
        }
        public StatoPorta getStatoPorta() {
            return statoPorta;
        }

    }
}