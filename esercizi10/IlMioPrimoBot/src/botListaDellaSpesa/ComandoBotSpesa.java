package botListaDellaSpesa;

import botBase.ComandoBotBase;

public enum ComandoBotSpesa {
    START("/start"),RESTART("/restart"),LISTA("Lista della spesa"),AGGIUNGI("Aggiungi"),RIMUOVI("Rimuovi"),ERRORE("errore");

    String str;
    private ComandoBotSpesa(String str){
        this.str = str;
    }

    /**
     * Metodo per poter costruire l'enum da Stringa
     * @param text
     * @return
     *
     */
    public static ComandoBotSpesa fromString(String text) {
        if (text != null) {
            for (ComandoBotSpesa c : ComandoBotSpesa.values()) {
                if (text.equals(c.str)) {
                    return c;
                }
            }
        }
        return ComandoBotSpesa.ERRORE;
    }
}
