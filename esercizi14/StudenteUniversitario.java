package it.corsobackendtree.esercizi14;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
public @interface StudenteUniversitario {
    UniversitaRomane universita();
}
