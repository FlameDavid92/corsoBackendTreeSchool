package it.corsobackendtree.esercizi17.civilregistry.classi;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CivilRegistry {
    private Set<Persona> persone;
    private static CivilRegistry instance = null;

    public static CivilRegistry getInstance() {
        if(instance == null) instance = new CivilRegistry();
        return instance;
    }

    private CivilRegistry(){
        /* Per un'ipotetica gestione multithread...*/
        persone = Collections.synchronizedSet(new HashSet<>());
    }

    public void inserisciPersona(Persona p){
        if(!persone.contains(p)){
            persone.add(p);
        }
        else System.out.println("Persona già presente!");
    }

    public void rimuoviPersona(CodiceFiscaleItaliano codiceFiscale){
        persone = persone.stream().parallel().filter(p -> !p.getCodiceFiscale().equals(codiceFiscale)).collect(Collectors.toSet());
    }

    public List<Persona> getPersone(String nomePersona){
        return getParallelStreamAfterNameFilter(nomePersona).collect(Collectors.toList());
    }

    public List<Persona> getTrePiuAnziani(){
        return persone.stream().parallel().sorted(Comparator.comparingInt(Persona::getEta).reversed()).limit(3).collect(Collectors.toList());
    }

    public List<Indirizzo> getIndirizzi(String nomePersona){
        return getParallelStreamAfterNameFilter(nomePersona)
                .map(Persona::getResidenza).collect(Collectors.toList());
    }

    public List<Persona> getFigli(String nomePersona){
        return getParallelStreamAfterNameFilter(nomePersona)
                .flatMap(e->e.figli.stream()).collect(Collectors.toList());
    }

    private Stream<Persona> getParallelStreamAfterNameFilter(String nomePersona){
        String lowerCaseName = nomePersona.toLowerCase().trim();
        return persone.stream().parallel().filter(p -> p.getNome().toLowerCase().startsWith(lowerCaseName));
    }
}
