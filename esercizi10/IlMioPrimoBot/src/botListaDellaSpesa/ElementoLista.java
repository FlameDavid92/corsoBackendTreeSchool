package botListaDellaSpesa;

public class ElementoLista {
    private String nome;
    private int quantita;

    public ElementoLista(String nome, int quantita){
        this.nome = nome;
        this.quantita = quantita;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantita() {
        return quantita;
    }
}
