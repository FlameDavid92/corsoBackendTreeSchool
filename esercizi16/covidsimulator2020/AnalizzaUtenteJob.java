package it.corsobackendtree.esercizi16.covidsimulator2020;

import java.io.BufferedWriter;
import java.io.IOException;

public class AnalizzaUtenteJob implements Runnable {
    public enum SituazioneClinica {
        SOTTOCONTROLLO,CAUTELA,CRITICA;
    }
    String line;
    final BufferedWriter writer;

    public AnalizzaUtenteJob(String line, BufferedWriter writer){
        this.line = line;
        this.writer = writer;
    }

    @Override
    public void run(){
        String[] dati = line.split(";");

        double temperatura = Double.parseDouble(dati[1]);
        int eta = Integer.parseInt(dati[2]);
        boolean gusto = Boolean.parseBoolean(dati[3]);;
        boolean tosse = Boolean.parseBoolean(dati[4]);;
        boolean debolezza = Boolean.parseBoolean(dati[5]);
        SituazioneClinica sitClin = SituazioneClinica.valueOf(dati[6]);

        boolean doWrite = false;

        if(temperatura >= 40) doWrite = true;
        else if(temperatura >= 38 && gusto && tosse && debolezza) doWrite = true;
        else if(sitClin.equals(SituazioneClinica.CRITICA) &&
                ( temperatura >= 38.5 || (gusto || tosse || debolezza))
                ) doWrite = true;
        else if(eta >= 50 && temperatura >= 37) doWrite = true;
        else if(eta >= 60 &&
                ((gusto && sitClin == SituazioneClinica.CAUTELA)||
                        (tosse && sitClin == SituazioneClinica.CRITICA))) doWrite = true;

        if(doWrite){
            synchronized (writer){
                try {
                    writer.write(dati[0]+"\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
