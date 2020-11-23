package it.corsobackendtree.esercizi17.civilregistry.classi;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CivilRegistry {
    private Set<Persona> persone;
    public static CivilRegistry instance = null;

    public static CivilRegistry getInstance() {
        if(instance == null) instance = new CivilRegistry();
        return instance;
    }

    private CivilRegistry(){
        persone = new HashSet<>();
    }

    public void inserisciPersona(Persona p){
        if(!persone.contains(p)) persone.add(p);
        else System.out.println("Persona già presente!");
    }

    public void rimuoviPersona(CodiceFiscaleItaliano codiceFiscale){
        persone = persone.stream().filter(p -> !p.getCodiceFiscale().equals(codiceFiscale)).collect(Collectors.toSet());
    }

    public List<Persona> getPersone(String nomePersona){
        return getStreamAfterNameFilter(nomePersona).collect(Collectors.toList());
    }

    public List<Persona> getTrePiuAnziani(){
        return persone.stream().sorted(Comparator.comparingInt(Persona::getEta).reversed()).limit(3).collect(Collectors.toList());
    }

    public List<Indirizzo> getIndirizzi(String nomePersona){
        return getStreamAfterNameFilter(nomePersona)
                .map(Persona::getResidenza).collect(Collectors.toList());
    }

    public List<Persona> getFigli(String nomePersona){
        return getStreamAfterNameFilter(nomePersona)
                .flatMap(e->e.figli.stream()).collect(Collectors.toList());
    }

    private Stream<Persona> getStreamAfterNameFilter(String nomePersona){
        String lowerCaseName = nomePersona.toLowerCase().trim();
        return persone.stream().filter(p -> p.getNome().toLowerCase().startsWith(lowerCaseName));
    }
}
