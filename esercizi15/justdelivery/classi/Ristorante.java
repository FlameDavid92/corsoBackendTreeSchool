package it.corsobackendtree.esercizi15.justdelivery.classi;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Ristorante {
    public enum TipoCucina{ITALIANA,VEGANA,VEGETARIANA,PIZZA,FASTFOOD,INDIANA,GIAPPONESE,CINESE}
    private String nome;
    private TipoCucina tipoCucina;
    private Set<Vivanda> menu;
    private BigDecimal speseConsegna;

    Ristorante(String nome, TipoCucina tipoCucina, double speseConsegna){
        this.nome = nome;
        this.tipoCucina = tipoCucina;
        menu = new LinkedHashSet<>();
        this.speseConsegna = new BigDecimal(speseConsegna);
    }

    public String getNome() {
        return nome;
    }

    public Set<Vivanda> getMenu() {
        return Set.copyOf(menu);
    }

    public TipoCucina getTipoCucina() {
        return tipoCucina;
    }

    public BigDecimal getSpeseConsegna() {
        return speseConsegna.setScale(2, RoundingMode.UP);
    }

    public void aggiungiVivandaAMenu(Vivanda vivanda){
        menu.add(vivanda);
    }
    public void aggiungiVivandeAMenu(Set<Vivanda> vivande){
        vivande.stream().forEach(v->menu.add(v));
    }

    public void printMenu(){
        menu.stream().forEach(v-> System.out.println(v));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ristorante that = (Ristorante) o;
        return Objects.equals(nome.toLowerCase(), that.nome.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome.toLowerCase());
    }
}
