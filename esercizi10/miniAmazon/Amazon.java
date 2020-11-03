package it.corsobackendtree.esercizi10.miniAmazon;

import java.time.LocalDateTime;
import java.util.*;

public class Amazon {
    private ArrayList<Magazzino> magazzini;
    private ArrayList<SoftwareRepository> softwareRepositories;
    private ArrayList<Utente> utenti;
    private Map<UUID, ArrayList<Ordine>> ordini;
    private Random rndm;

    public Amazon() {
        this.magazzini = new ArrayList<>();
        this.softwareRepositories = new ArrayList<>();
        this.utenti = new ArrayList<>();
        this.ordini = new HashMap<>();
        this.rndm = new Random();
    }

    public boolean registraUtente(Utente ut) {
        return utenti.add(ut);
    }

    public long getnUtenti(){
        return utenti.size();
    }

    public boolean aggiungiMagazzino(Magazzino m) {
        return magazzini.add(m);
    }

    public boolean aggiungiSoftwareRepository(SoftwareRepository sr) {
        return softwareRepositories.add(sr);
    }

    public boolean creaAggiungiOrdine(UUID idUtente, ArrayList<Prodotto> prodotti) {
        boolean check = false;

        for(Prodotto prodotto : prodotti){
            check = false;
            Deposito dep = trovaProdotto(prodotto.getId()).getDeposito();
            if(dep != null){
                if(dep instanceof Magazzino){
                    check = true;
                    prodotto.acquista();
                    if( ((ProdottoFisico) prodotto).getQuantitaDisponibile()==0 ){
                        ((Magazzino) dep).removeProdotto(prodotto);
                    }
                }else if(dep instanceof SoftwareRepository){
                    check = true;
                    prodotto.acquista();
                }
            }
        }

        Ordine ordine = new Ordine(idUtente, prodotti, LocalDateTime.now());
        if (ordini.get(idUtente) == null) {
            ArrayList<Ordine> ordiniUtente = new ArrayList<>();
            ordiniUtente.add(ordine);
            ordini.put(idUtente, ordiniUtente);
        } else {
            ordini.get(idUtente).add(ordine);
        }
        return true;
    }

    public QueryOrdiniResult getOrdiniUtente(UUID idUtente) {
        return new QueryOrdiniResult(idUtente, ordini.get(idUtente));
    }

    public boolean aggiungiProdotto(Prodotto p) {
        if (p instanceof ProdottoSoftware) {
            return aggiungiProdottoSoftware((ProdottoSoftware) p);
        } else if (p instanceof ProdottoFisico) {
            return aggiungiProdottoFisico((ProdottoFisico) p);
        } else return false;
    }

    private boolean aggiungiProdottoFisico(ProdottoFisico pf) {
        if(magazzini.size() == 0){
            System.out.println("Non ci sono magazzini!");
            return false;
        }
        Magazzino m = null;
        int max = Integer.MIN_VALUE;
        for (Magazzino magazzino : magazzini) {
            if (magazzino.getSpazioDisponibile() > max) {
                m = magazzino;
            }
        }
        if (m != null) {
            return m.addProdotto(pf);
        } else return false;
    }

    private boolean aggiungiProdottoSoftware(ProdottoSoftware ps) {
        if(softwareRepositories.size() == 0){
            System.out.println("Non ci sono repositories!");
            return false;
        }else {
            int index = rndm.nextInt(softwareRepositories.size());
            return softwareRepositories.get(index).addProdotto(ps);
        }
    }

    public QueryProdottoResult trovaProdottoFisico(UUID idProdotto) {
        Magazzino retMagazzino = null;
        Prodotto retProdotto = null;
        int max = 0;
        int quantita;
        for (Magazzino magazzino : magazzini) {
            quantita = 0;
            for (Prodotto prodotto : magazzino.getProdottiFisici()) {
                if (prodotto.getId().equals(idProdotto)) {
                    quantita++;
                    if(retProdotto == null){
                        retProdotto = prodotto;
                    }
                }
            }
            if(max < quantita) {
                max = quantita;
                retMagazzino = magazzino;
            }
        }
        return new QueryProdottoResult(retProdotto,retMagazzino);
    }

    public QueryProdottoResult trovaProdottoSoftware(UUID idProdotto) {
        for (SoftwareRepository repository : softwareRepositories) {
            for (Prodotto prodotto : repository.getProdottiSoftware()) {
                if (prodotto.getId().equals(idProdotto)) {
                    return new QueryProdottoResult(prodotto,repository);
                }
            }
        }
        return new QueryProdottoResult(null,null);
    }

    public QueryProdottoResult trovaProdotto(UUID idProdotto) {
        QueryProdottoResult qpr = trovaProdottoFisico(idProdotto);
        if (qpr.getProdotto() != null) {
            return qpr;
        }
        else {
            qpr = trovaProdottoSoftware(idProdotto);
            if (qpr != null) return qpr;
            else return null;
        }
    }

    public long getAcquisti(UUID idProdotto){
        Prodotto p = trovaProdotto(idProdotto).getProdotto();
        return p.getnAcquisti();
    }
}
