package it.corsobackendtree.esercizi15.facebook.classi;

import java.time.Instant;
import java.util.*;

public class Utente {
    private UUID id;
    private Instant timestamp;
    private String nome;
    private String cognome;
    private Set<Utente> amici;
    private Set<Post> posts;
    private Set<Post> postCommentati;
    private Set<Post> postPiaciuti;

    protected Utente(String nome, String cognome){
        id = UUID.randomUUID();
        timestamp = Instant.now();
        this.nome = nome;
        this.cognome = cognome;
        amici = new HashSet<>();
        posts = new HashSet<>();
        postCommentati = new HashSet<>();
        postPiaciuti = new HashSet<>();
    }

    protected boolean aggiungiAmico(Utente amico){
        if(amico.equals(this)) return false; /*Non posso essere amico di me stesso :( */
        else{
            return amici.add(amico); /* true se aggiunge, false se già presente*/
        }
    }

    protected boolean rimuoviAmico(Utente amico){
        return amici.remove(amico);
    }

    protected void cambiaNome(String nome){
        this.nome = nome;
    }

    protected void cambiaCognome(String cognome){
        this.cognome = cognome;
    }

    protected Post pubblicaPost(String testoPost){
        Post nuovoPost = new Post(testoPost);
        posts.add(nuovoPost);
        return nuovoPost;
    }

    protected Commento commentaPost(Post post, String testoCommento){
        Commento nuovoCommento = new Commento(this,post,testoCommento);
        post.aggiungiCommento(nuovoCommento);
        postCommentati.add(post);
        return nuovoCommento;
    }

    protected boolean mettiLikeAPost(Post post){
        Like nuovoLike = new Like(this,post);
        if(post.aggiungiLike(nuovoLike)){
            postPiaciuti.add(post);
            return true;
        }else return false;
    }

    /*rimuoviCommento-rimuoviLike*/

    protected Set<Post> getPosts(){
        return posts;
    }

    protected Set<Post> getPostCommentati() {
        return postCommentati;
    }

    protected Set<Post> getPostPiaciuti() {
        return postPiaciuti;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public List<Utente> getAmici() {
        return new LinkedList<Utente>(amici);
    }

    protected boolean equalsNomeCognome(String nome, String cognome){
        return (this.nome.toLowerCase().equals(nome.toLowerCase())) && (this.cognome.toLowerCase().equals(cognome.toLowerCase()));
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utente utente = (Utente) o;
        return Objects.equals(id, utente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
