package botBase;

public enum ComandoBotBase {
    SALUTA,MONOPATTINO,SCOOTER,MOTO,TASTIERA,ERRORE;
    public static ComandoBotBase fromString(String text){
        if(text.toLowerCase().equals("ciao") || text.toLowerCase().equals("/start")) return ComandoBotBase.SALUTA;
        else if(text.toLowerCase().equals(("tastiera"))) return ComandoBotBase.TASTIERA;
        else if(text.toLowerCase().equals("\uD83D\uDEF4")) return ComandoBotBase.MONOPATTINO;
        else if(text.toLowerCase().equals("\uD83D\uDEF5")) return ComandoBotBase.SCOOTER;
        else if(text.toLowerCase().equals("\uD83C\uDFCD")) return ComandoBotBase.MOTO;
        else return ComandoBotBase.ERRORE;
    }
}
