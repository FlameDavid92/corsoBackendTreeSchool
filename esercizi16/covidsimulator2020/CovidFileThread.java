package it.corsobackendtree.esercizi16.covidsimulator2020;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;

public class CovidFileThread extends Thread {
    String filepath;
    BufferedWriter writer;

    public CovidFileThread(String filepath, BufferedWriter writer){
        this.filepath = filepath;
        this.writer = writer;
    }

    @Override
    public void run() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filepath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(br != null){
            String line;
            try{
                while ((line = br.readLine()) != null) {
                    analizzaUtente(line,writer);
                }
                br.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    private void analizzaUtente(String line, BufferedWriter writer){
        String[] dati = line.split(";");

        double temperatura = Double.parseDouble(dati[1]);
        int eta = Integer.parseInt(dati[2]);
        boolean gusto = Boolean.parseBoolean(dati[3]);;
        boolean tosse = Boolean.parseBoolean(dati[4]);;
        boolean debolezza = Boolean.parseBoolean(dati[5]);
        AnalizzaUtenteJob.SituazioneClinica sitClin = AnalizzaUtenteJob.SituazioneClinica.valueOf(dati[6]);

        boolean doWrite = false;

        if(temperatura >= 40) doWrite = true;
        else if(temperatura >= 38 && gusto && tosse && debolezza) doWrite = true;
        else if(sitClin.equals(AnalizzaUtenteJob.SituazioneClinica.CRITICA) &&
                ( temperatura >= 38.5 || (gusto || tosse || debolezza))
        ) doWrite = true;
        else if(eta >= 50 && temperatura >= 37) doWrite = true;
        else if(eta >= 60 &&
                ((gusto && sitClin == AnalizzaUtenteJob.SituazioneClinica.CAUTELA)||
                        (tosse && sitClin == AnalizzaUtenteJob.SituazioneClinica.CRITICA))) doWrite = true;

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
