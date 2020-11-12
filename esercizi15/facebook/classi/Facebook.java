package it.corsobackendtree.esercizi15.facebook.classi;

import java.util.*;

public class Facebook {
    private Map<UUID,Utente> utenti;

    public Facebook(){
        utenti = new LinkedHashMap<>();
    }

    public Utente iscriviUtente(String nome, String cognome){
        Utente nuovoUtente = new Utente(nome,cognome);
        utenti.put(nuovoUtente.getId(),nuovoUtente);
        return nuovoUtente;
    }

    public void creaAmicizia(Utente utente1, Utente utente2){
        utente1.aggiungiAmico(utente2);
        utente2.aggiungiAmico(utente1);
    }

    public void rimuoviAmicizia(Utente utente1, Utente utente2){
        utente1.rimuoviAmico(utente2);
        utente2.rimuoviAmico(utente1);
    }

    public void cambiaNomeUtente(Utente utente, String nuovoNome){
        utente.cambiaNome(nuovoNome);
    }

    public void cambiaCognomeUtente(Utente utente, String nuovoCognome){
        utente.cambiaCognome(nuovoCognome);
    }

    public Post pubblicaPostUtente(Utente utente, String testoPost){
        return utente.pubblicaPost(testoPost);
    }

    /*mmmmmmm.....*/
    public Utente[] getUltimi3NuoviUtenti(){
        Utente[] ret = new Utente[3];
        Set<UUID> keys = utenti.keySet();
        Iterator<UUID> it = keys.iterator();
        for(int i=0; i<utenti.size()-3; i++) it.next();
        ret[0] = utenti.get(it.next());
        ret[1] = utenti.get(it.next());
        ret[2] = utenti.get(it.next());
        return ret;
    }

    public Utente getUtenteById(UUID idUtente){
        return utenti.get(idUtente);
    }

    /*
     * dati nome e cognome ritornare la lista di utenti che hanno quei nome e cognome
     */
    public List<Utente> getUtenti(String nome, String cognome){
        LinkedList<Utente> respUt = new LinkedList<>();
        Utente temp;
        for (Map.Entry<UUID,Utente> entry : utenti.entrySet()) {
            temp = entry.getValue();
            if(temp.equalsNomeCognome(nome, cognome)){
                respUt.add(temp);
            }
        }
        return respUt;
    }

    public Set<Post> getPostsUtente(Utente utente){
        return utente.getPosts();
    }

    public Set<Post> getPostCommentati(Utente utente){
        return utente.getPostCommentati();
    }

    public Set<Post> getPostPiaciuti(Utente utente){
        return utente.getPostPiaciuti();
    }

    public Commento utenteCommentaPost(Utente utente, Post post, String testoCommento){
        return utente.commentaPost(post, testoCommento);
    }

    public boolean utenteInserisceLikeAPost(Utente utente, Post post){
        return utente.mettiLikeAPost(post);
    }

    public int getNUtentiIscritti(){
        return utenti.size();
    }
}
