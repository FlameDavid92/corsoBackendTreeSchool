package it.corsobackendtree.esercizi9.ferrovia.classi;

import java.util.*;

public abstract class Treno {
    private UUID codice;
    private double velocitaKmH;
    private int maxVagoni;
    protected boolean fermo;
    protected ArrayList<Vagone> vagoni;

    public Treno(int maxVagoni) {
        this.codice = UUID.randomUUID();
        this.velocitaKmH = 0;
        this.maxVagoni = maxVagoni;
        this.fermo = true;
        this.vagoni = new ArrayList<>();
    }

    public void parti() {
        this.chiudiTutteLePorte();
        this.fermo = false;
        this.velocitaKmH = 80;
    }
    public void frena() {
        this.velocitaKmH = 0;
    }
    public void entraInStazione() {
        this.fermo = true;
    }
    public boolean isInStazione() { return this.fermo; }

    public void aggiungiVagone(Vagone v) {
        if (!this.fermo) {
            System.out.println("Non puoi aggiungere vagoni se non sei in stazione!");
            return;
        }

        if (vagoni.size() < maxVagoni) {
            this.vagoni.add(v);
        } else {
            System.out.println("Non puoi più aggiungere vagoni, " +
                    "hai raggiunto il limite massimo!");
        }
    }

    public void rimuoviVagone(Vagone v) {
        if (vagoni.size() > 0) {
            if (v.isEmpty()) {
                this.vagoni.remove(v);
            } else {
                System.out.println("Il vagone non è vuoto, non puoi rimuovere il vagone!");
            }
        } else {
            System.out.println("Non ci sono vagoni!");
        }
    }

    public boolean entraPasseggero(Vagone v, Passeggero p) {
        if (!this.fermo) {
            System.out.println("Un passeggero può salire solo in stazione!");
            return false;
        }
        return v.entraPasseggero(p);
    }

    public boolean escePasseggero(Vagone v, Passeggero p) {
        if (!this.fermo) {
            System.out.println("Un passeggero può scendere solo in stazione!");
            return false;
        }
        return v.escePasseggero(p);
    }

    public void inStazione(int idStazioneArrivo){
        this.frena();
        this.entraInStazione();
        if(!(this instanceof  FrecciaRossa)) this.apriTutteLePorte();

        /*Fai scendere passeggeri arrivati*/
        Map<Vagone, ArrayList<Passeggero>> daFarUscire = new HashMap<>();
        for(Vagone v : vagoni){
            for(Passeggero p : v.getPasseggeri()){
                if(p.idStazioneArrivo == idStazioneArrivo){
                    if(daFarUscire.get(v) == null){
                        ArrayList<Passeggero> passeggeriDaFarUscire = new ArrayList<>();
                        passeggeriDaFarUscire.add(p);
                        daFarUscire.put(v,passeggeriDaFarUscire);
                    }else{
                        daFarUscire.get(v).add(p);
                    }
                }
            }
        }
        
        for(Vagone v : daFarUscire.keySet()){
            for(Passeggero p : daFarUscire.get(v)){
                v.escePasseggero(p);
            }
        }
        this.chiudiTutteLePorte();
        this.parti();
    }

    public int getNumPasseggeri() {
        int ret = 0;
        for (Vagone v : this.vagoni) {
            ret += v.getNumPasseggeri();
        }
        return ret;
    }

    public void apriTutteLePorte() {
        for (Vagone v : this.vagoni) {
            v.apriPorte();
        }
    }

    public void chiudiTutteLePorte() {
        for (Vagone v : this.vagoni) {
            v.chiudiPorte();
        }
    }
}
