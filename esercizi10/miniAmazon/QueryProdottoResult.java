package it.corsobackendtree.esercizi10.miniAmazon;

public class QueryProdottoResult {
    private Prodotto prodotto;
    private Deposito deposito;

    public QueryProdottoResult(Prodotto prodotto, Deposito deposito){
        this.prodotto = prodotto;
        this.deposito = deposito;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public Deposito getDeposito() {
        return deposito;
    }
}
