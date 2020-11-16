package it.corsobackendtree.esercizi15.spotreefy;

import it.corsobackendtree.esercizi15.spotreefy.classi.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Spotreefy spt = Spotreefy.getInstance();
        Autore autore1 = new Autore("Claudio","Baglioni");
        Autore autore2 = new Autore("Antonello","Venditti");
        Autore autore3 = new Autore("Mina","Mina Anna Maria","Mazzini");

        Brano etu = spt.aggiungiBrano(autore1.getId(),"E tu","Pop");
        Brano qpga = spt.aggiungiBrano(autore1.getId(),"Questo piccolo grande amore","Pop");
        Brano cfsv = spt.aggiungiBrano(autore2.getId(),"Che fantastica storia è la vita","Pop");
        Brano epoi = spt.aggiungiBrano(autore3.getId(),"E poi","Pop");

        spt.registraUtente("Davide","davide@ok.it");
        spt.registraUtente("Chiara","chiara@ok.it");
        spt.registraUtente("Alessio","alessio@ok.it");

        Utente davide = spt.getUtente("davide@ok.it");
        Utente chiara = spt.getUtente("chiara@ok.it");
        Utente alessio = spt.getUtente("alessio@ok.it");

        davide.seguiUtente(chiara.getEmail());

        System.out.println(davide.getUtentiSeguiti().size() == 1);

        davide.addBranoInCoda(etu.getIdBrano());
        davide.addBranoInTesta(epoi.getIdBrano());
        davide.addBranoInCoda(cfsv.getIdBrano());
        davide.addBranoInTesta(qpga.getIdBrano());

        System.out.println(spt.getProssimoBrano(davide).getTitolo().equals(qpga.getTitolo()));
        System.out.println(spt.getProssimoBrano(davide).getTitolo().equals(epoi.getTitolo()));
        System.out.println(spt.getProssimoBrano(davide).getTitolo().equals(etu.getTitolo()));
        System.out.println(spt.getProssimoBrano(davide).getTitolo().equals(cfsv.getTitolo()));

        System.out.println("-------");

        Playlist playlistAlessio1 = alessio.creaPlaylist("AlessiosPlaylist");
        playlistAlessio1.aggiungiBrano(alessio,qpga.getIdBrano());
        playlistAlessio1.aggiungiBrano(alessio,epoi.getIdBrano());

        alessio.addBranoInCoda(qpga.getIdBrano());
        alessio.addBranoInTesta(epoi.getIdBrano());

        System.out.println(spt.calcolaAscoltiPlaylist(playlistAlessio1) == 2);

        System.out.println(spt.getProssimoBrano(alessio).getTitolo().equals(epoi.getTitolo()));

        System.out.println(spt.calcolaAscoltiPlaylist(playlistAlessio1) == 3);

        Playlist playlistDavide1 = davide.creaPlaylist("DavidesPlaylist");
        playlistDavide1.aggiungiBrano(davide,qpga.getIdBrano());
        playlistDavide1.aggiungiBrano(davide,epoi.getIdBrano());
        playlistDavide1.aggiungiBrano(davide,etu.getIdBrano());

        System.out.println(spt.getPlaylistPiuAscoltata().getNome().equals("DavidesPlaylist"));

        alessio.seguiUtente(davide.getEmail());
        List<Brano> discover1 = spt.discover(alessio,2);
        System.out.println(discover1.size()==2);
        System.out.println("DISCOVER: "+discover1);

        davide.addBranoInTesta(qpga.getIdBrano());
        spt.getProssimoBrano(davide);

        System.out.println(davide.getAscolti(qpga.getIdBrano()) == 2);

        for(Playlist pl : spt.recommendation2(davide,1)){
            System.out.println(pl.getNome());
        }
    }
}
