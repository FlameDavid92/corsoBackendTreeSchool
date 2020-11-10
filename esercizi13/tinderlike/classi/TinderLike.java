package it.corsobackendtree.esercizi13.tinderlike.classi;

import java.util.*;

public class TinderLike {
    private Map<UUID, Utente> utenti;

    public TinderLike() {
        utenti = new HashMap<>();
    }

    public Utente iscriviUtente(String nome, String cognome, Interesse primoInteresse) {
        Utente nuovoUtente = new Utente(nome, cognome);
        nuovoUtente.aggiungiInteresse(primoInteresse);
        utenti.put(nuovoUtente.getId(), nuovoUtente);
        return nuovoUtente;
    }

    public void aggiungiInteresseUtente(Utente ut, Interesse i) throws UserNotRegisteredException {
        if(!isRegistered(ut)) throw new UserNotRegisteredException();
        ut.aggiungiInteresse(i);
    }

    public void aggiungiInteressiUtente(Utente ut, ArrayList<Interesse> interessi) throws UserNotRegisteredException {
        if(!isRegistered(ut)) throw new UserNotRegisteredException();
        for (Interesse i : interessi) ut.aggiungiInteresse(i);
    }

    public ArrayList<Interesse> getInteressiUtente(Utente ut) throws UserNotRegisteredException {
        if(!isRegistered(ut)) throw new UserNotRegisteredException();
        ArrayList<Interesse> interessi = new ArrayList<>();
        interessi.addAll(ut.getInteressi());
        return interessi;
    }

    public boolean rimuoviUtente(Utente ut) {
        return utenti.remove(ut.getId()) != null;
    }

    public Utente getBestMatch(Utente u) throws UserNotRegisteredException {
        if(!isRegistered(u)) throw new UserNotRegisteredException();
        TreeSet<Interesse> interessiUtente = u.getInteressi();
        Utente match = null;
        int limit = interessiUtente.size();
        int max = -1;
        int temp;
        Utente tempUt;
        for (UUID idUtente : utenti.keySet()) {
            if (!idUtente.equals(u.getId())) {
                tempUt = utenti.get(idUtente);
                temp = matchInteressi(interessiUtente, tempUt.getInteressi());
                if (temp > max) {
                    max = temp;
                    match = tempUt;
                    if(max == limit) break; /*Ho trovato un utente che ha tutti gli interessi di u, non mi serve continuare a cercarne altri*/
                }
            }
        }
        return match;
    }

    public ArrayList<Utente> getBestMatches(Utente u) throws UserNotRegisteredException {
        if(!isRegistered(u)) throw new UserNotRegisteredException();
        TreeSet<Interesse> interessiUtente = u.getInteressi();
        ArrayList<Utente> matches = new ArrayList<>();

        int max = -1;
        int temp;
        Utente tempUt;
        for (UUID idUtente : utenti.keySet()) {
            if (!idUtente.equals(u.getId())) {
                tempUt = utenti.get(idUtente);
                temp = matchInteressi(interessiUtente, tempUt.getInteressi());
                if (temp > max) {
                    matches = new ArrayList<>();
                    matches.add(tempUt);
                    max = temp;
                }else if(temp == max){
                    matches.add(tempUt);
                }
            }
        }
        return matches;
    }

    private int matchInteressi(TreeSet<Interesse> interessi1, TreeSet<Interesse> interessi2) {
        int ret = 0;
        Iterator<Interesse> iterator1 = interessi1.iterator();
        Iterator<Interesse> iterator2 = interessi2.iterator();
        Interesse intUt1 = iterator1.next();
        Interesse intUt2 = iterator2.next();
        while (true)
            if (intUt1.equals(intUt2)) {
                ret++;
                if(!iterator1.hasNext() || !iterator2.hasNext()) break;
                else{
                    intUt1 = iterator1.next();
                    intUt2 = iterator2.next();
                }
            }else if(intUt1.compareTo(intUt2) < 0){
                if(!iterator1.hasNext()) break;
                else intUt1 = iterator1.next();
            }else {
                if(!iterator2.hasNext()) break;
                else intUt2 = iterator2.next();
            }
        return ret;
    }

    private boolean isRegistered(Utente ut){
        return utenti.containsKey(ut.getId());
    }
}
