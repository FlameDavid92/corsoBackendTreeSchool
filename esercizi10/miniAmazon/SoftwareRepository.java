package it.corsobackendtree.esercizi10.miniAmazon;

import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.UUID;

public class SoftwareRepository implements Deposito{
    private UUID id;
    private ArrayList<ProdottoSoftware> prodottiSoftware;

    public SoftwareRepository(){
        this.id = UUID.randomUUID();
        this.prodottiSoftware = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    @Override
    public boolean addProdotto(Prodotto p) {
        if(p instanceof ProdottoSoftware){
            return prodottiSoftware.add((ProdottoSoftware) p);
        }else{
            System.out.println("Prodotto non aggiunto. Puoi aggiungere solo prodotti software alla repository!");
            return false;
        }
    }

    @Override
    public boolean removeProdotto(Prodotto p) {
        if(p instanceof ProdottoSoftware){
            return prodottiSoftware.remove((ProdottoSoftware) p);
        }else{
            System.out.println("Puoi rimuovere solo prodotti software dalla repository!");
            return false;
        }
    }

    public ArrayList<ProdottoSoftware> getProdottiSoftware(){
        return prodottiSoftware;
    }
}
