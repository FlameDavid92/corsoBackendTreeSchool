package it.corsobackendtree.esercizi18;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static spark.Spark.*;

public class MiniEcommerce {
    private static final HashMap<UUID,Prodotto> prodotti = new HashMap<>();
    private static final Gson gson = new Gson();

    public static void main(String[] args) {
        hello();
        aggiungiProdotto();
        eliminaProdotto();
        getListaProdotti();
        acquistaProdotto();
    }

    private static void hello(){
        get("/hello",(req,res) -> "Ciaooooooooooo!");
    }

    private static void aggiungiProdotto(){
        /*controllo se prodotto già presente!*/
        post("/prodotti/add", (req,res) -> {
            Prodotto nuovoProdotto = gson.fromJson(req.body(),Prodotto.class);
            //prodotti.values().stream().findAny();
            prodotti.put(nuovoProdotto.getId(),nuovoProdotto);
            res.status(201);
            res.type("application/json");
            return "Prodotto aggiunto!";
        });
    }
    private static void eliminaProdotto(){
        delete("/prodotti/remove", (req,res) -> {
            if(prodotti.remove(UUID.fromString(req.queryMap().get("id").value())) != null){
                res.status(200);
                res.type("application/json");
                return "Prodotto eliminato!";
            }else{
                res.status(404);
                return "Prodotto non presente!";
            }
        });
    }
    private static void getListaProdotti(){
        get("/prodotti",(req,res) ->{
            res.status(200);
            res.type("application/json");
            List<Prodotto> ret = prodotti.values().stream().filter(p -> p.getQuantitaDisponibile() > 0).collect(Collectors.toList());
            if(ret.size() > 0) {
                res.status(200);
                return gson.toJson(ret);
            }
            res.status(200);
            return "Non ci sono prodotti disponibili!";
        });
    }
    private static void acquistaProdotto(){
        put("/prodotti/acquista", (req,res) -> {
            UUID id = UUID.fromString(req.queryMap().get("id").value());
            if(prodotti.containsKey(id)){
                Prodotto pr = prodotti.get(id);
                int quantita;
                try{
                    quantita = Integer.parseInt(req.queryMap().get("quantita").value());
                }catch(NumberFormatException e){
                    res.status(400);
                    return "Formato richiesta non corretto!";
                }
                if(pr.acquisto(quantita)){
                    res.status(201);
                    res.type("application/json");
                    return "Acquisto completato!";
                }else{
                    res.status(400);
                    return "Quantità non disponibile!";
                }
            }else{
                res.status(404);
                return "Prodotto non trovato!";
            }
        });
    }
}
