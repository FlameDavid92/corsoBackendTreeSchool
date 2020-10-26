package it.corsobackendtree.esercizi6.dittadiriparazioni;

public class DittaRiparazioni {
    private Tecnico[] tecnici;
    int lastFreeIndexTec;
    private Riparazione[] inAttesa;
    private int lastFreeIndexInAtt;
    private Riparazione[] completate;
    private int lastFreeIndexCompl = 0;
    private int cancellazioni = 0;

    public DittaRiparazioni(){
        this.tecnici = new Tecnico[100];
        this.lastFreeIndexTec = 0;
        this.inAttesa = new Riparazione[100];
        this.lastFreeIndexInAtt = 0;
        this.completate = new Riparazione[100];
        this.lastFreeIndexCompl = 0;
    }

    public void aggiungiRiparazione(Riparazione rp){
        if(this.cancellazioni == 30){
            this.clearInAttesa();
        }
        if(lastFreeIndexInAtt >= this.inAttesa.length){
            Riparazione[] newInAttesa = new Riparazione[this.inAttesa.length*2];
            for(int i=0; i<this.inAttesa.length;i++){
                newInAttesa[i] = this.inAttesa[i];
            }
            this.lastFreeIndexInAtt = this.inAttesa.length;
            this.inAttesa = newInAttesa;
        }
        this.inAttesa[lastFreeIndexInAtt] = rp;
        lastFreeIndexInAtt++;
    }

    public void aggiungiRiparazioneCompletata(Riparazione rp){
        if(lastFreeIndexCompl >= this.completate.length){
            Riparazione[] newCompletate = new Riparazione[this.completate.length*2];
            for(int i=0; i<this.completate.length;i++){
                newCompletate[i] = this.completate[i];
            }
            this.lastFreeIndexCompl = this.completate.length;
            this.completate = newCompletate;
        }
        this.completate[lastFreeIndexCompl] = rp;
        lastFreeIndexCompl++;
    }

    public Riparazione[] getRiparazioniInAttesa(){
        return this.inAttesa;
    }
    public Riparazione getRiparazionePrioritaMax(){
        int max = -1;
        int indMax = -1;
        for(int i=0; i<lastFreeIndexInAtt; i++){
            if( this.inAttesa[i].getPriorita() > max && !inAttesa[i].isGestita() ){
                max = this.inAttesa[i].getPriorita();
                indMax = i;
            }
        }
        if(indMax == -1) return null;

        return inAttesa[indMax];
    }

    public void aggiungiTecnico(Tecnico tc){
        /*se c'è spazio!!!*/
        if(lastFreeIndexInAtt >= this.inAttesa.length){
            Tecnico[] newTecnici = new Tecnico[this.tecnici.length*2];
            for(int i=0; i<this.tecnici.length;i++){
                newTecnici[i] = this.tecnici[i];
            }
            this.lastFreeIndexTec = this.tecnici.length;
            this.tecnici = newTecnici;
        }
        this.tecnici[lastFreeIndexTec] = tc;
        lastFreeIndexTec++;
    }

    public boolean assegnaIncarico(){
        Tecnico tec = null;
        /*Cerco il primo tecnico disponibile*/
        for(int i=0;i<lastFreeIndexTec; i++){
            if(tecnici[i].isDisponibile()){
                System.out.println("Tecnico assegnato: "+tecnici[i].getNome());
                tec = tecnici[i];
                break;
            }
        }
        if(tec == null){
            System.out.println("Non ci sono tecnici disponibili!");
            return false;
        }

        /* Cerco la riparazione con priorità maggiore */
        Riparazione ripar = this.getRiparazionePrioritaMax();
        System.out.println("Riparazione all'indirizzo "+ripar.getIndirizzo());
        if(ripar == null){
            System.out.println("Non ci sono riparazioni non gestite!");
            return false;
        }
        tec.setIncaricoAttuale(ripar);
        ripar.assegnaTecnico(tec);
        return true;
    }

    public void mandaInFerie(String[] nomi){
        for(int i=0;i<lastFreeIndexTec;i++){
            for(String nome : nomi){
                if(tecnici[i].getNome().equals(nome)){
                    tecnici[i].vaInFerie();
                    break;
                }
            }
        }
    }

    public void concludiRiparazione(Tecnico t){
        Riparazione r = t.getIncaricoAttuale();
        t.concludiIncarico();
        r.concludi();
        this.aggiungiRiparazioneCompletata(r);
        this.cancellazioni++;
    }

    public void clearInAttesa(){
        Riparazione[] newInAttesa = new Riparazione[this.inAttesa.length];
        int j = 0;
        for(int i=0;i< this.inAttesa.length;i++){
            if(!inAttesa[i].isConclusa()){
                newInAttesa[j] = inAttesa[i];
                j++;
            }
        }
        this.lastFreeIndexInAtt = j;
        this.inAttesa = newInAttesa;
    }
}
