package it.corsobackendtree.esercizi9.ferrovia.classi;

import java.util.ArrayList;
import java.util.UUID;

public abstract class Treno {
    private UUID codice;
    private double velocitaKmH;
    private int maxVagoni;
    protected boolean fermo;
    protected ArrayList<Vagone> vagoni;

    public Treno(double velocita, int maxVagoni) {
        this.codice = UUID.randomUUID();
        this.velocitaKmH = velocita;
        this.maxVagoni = maxVagoni;
        this.fermo = false;
        this.vagoni = new ArrayList<>();
    }

    public void parti() {
        this.fermo = false;
        this.velocitaKmH = 80;
    }
    public void frena() {
        this.velocitaKmH = 0;
    }
    public void entraInStazione() {
        this.fermo = true;
    }

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

    public void entraPasseggero(Vagone v, Passeggero p) {
        if (!this.fermo) {
            System.out.println("Un passeggero può salire solo in stazione!");
            return;
        }
        v.entraPasseggero(p);
    }

    public void escePasseggero(Vagone v, Passeggero p) {
        if (!this.fermo) {
            System.out.println("Un passeggero può scendere solo in stazione!");
            return;
        }
        v.escePasseggero(p);
    }

    public int getNumPasseggeri() {
        int ret = 0;
        for (Vagone v : this.vagoni) {
            ret+=v.getNumPasseggeri();
        }
        return ret;
    }

    public void apriTutteLePorte() {
        for (Vagone v : this.vagoni) {
            v.apriPorte();
        }
    }
}
