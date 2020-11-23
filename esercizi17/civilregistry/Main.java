package it.corsobackendtree.esercizi17.civilregistry;

import it.corsobackendtree.esercizi17.civilregistry.classi.CivilRegistry;
import it.corsobackendtree.esercizi17.civilregistry.classi.CodiceFiscaleItaliano;
import it.corsobackendtree.esercizi17.civilregistry.classi.Indirizzo;
import it.corsobackendtree.esercizi17.civilregistry.classi.Persona;

public class Main {
    public static void main(String[] args) {
        CivilRegistry cr = CivilRegistry.getInstance();

        CodiceFiscaleItaliano cfDavide = null;
        try {
            cfDavide = new CodiceFiscaleItaliano("FGCDVD92P22I712A");
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        Indirizzo indirizzoDavide = new Indirizzo("Via Ttt ppp",10,"Marsala");

        CodiceFiscaleItaliano cfSofia = null;
        try {
            cfSofia = new CodiceFiscaleItaliano("BNCSFO12C45E974Y");
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        Indirizzo indirizzoDavide3 = new Indirizzo("Via Www qqq",59,"Marsala");

        CodiceFiscaleItaliano cfBello = null;
        CodiceFiscaleItaliano cfBello2 = null;
        CodiceFiscaleItaliano cfBello3 = null;
        CodiceFiscaleItaliano cfBello4 = null;
        try {
            cfBello = new CodiceFiscaleItaliano("BLLBLL80A01E974O");
            cfBello2 = new CodiceFiscaleItaliano("BLLBLL81A01E974O");
            cfBello3 = new CodiceFiscaleItaliano("BLLBLL82A01E974O");
            cfBello4 = new CodiceFiscaleItaliano("BLLBLL83A01E974O");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Indirizzo indirizzoBello = new Indirizzo("Via bellissima",0,"Bella");

        Persona davide = new Persona(cfDavide,"Davide","Figuccia",28, indirizzoDavide);
        Persona davide2 = new Persona(cfBello,"Davide","Rossi",70, indirizzoBello);
        Persona davide3 = new Persona(cfBello2,"Davide","Bianchi",35, indirizzoDavide3);
        Persona sofia = new Persona(cfSofia, "Sofia", "Bianchi", 6, indirizzoDavide3);
        Persona lucia = new Persona(cfBello3, "Lucia", "Luce", 72, indirizzoBello);
        Persona mario = new Persona(cfBello4,"Mario","Verdi",35, indirizzoBello);
        davide3.aggiungiFiglio(sofia);
        davide2.aggiungiFiglio(mario);
        cr.inserisciPersona(davide);
        cr.inserisciPersona(davide3);
        cr.inserisciPersona(davide2);
        cr.inserisciPersona(lucia);

        System.out.println("GET PERSONE (\"davide\")");
        System.out.println(cr.getPersone("davide"));
        System.out.println("-------");
        System.out.println("GET INDIRIZZI (\"davide\")");
        System.out.println(cr.getIndirizzi("davide"));
        System.out.println("-------");
        System.out.println("GET TRE PIU' ANZIANI");
        System.out.println(cr.getTrePiuAnziani());
        System.out.println("-------");
        System.out.println("GET FIGLI (\"davide\")");
        System.out.println(cr.getFigli("davide"));
        System.out.println("-------");
        System.out.println("GET PERSONE (\"davide\") [dopo rimozione di Davide Figuccia]");
        cr.rimuoviPersona(cfDavide);
        System.out.println(cr.getPersone("davide"));
    }
}
