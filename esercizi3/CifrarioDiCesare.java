package it.corsobackendtree.esercizi3;

public class CifrarioDiCesare {
    public static void main(String[] args){
        CifrarioDiCesare cdc = new CifrarioDiCesare();
        String resp = cdc.criptaDecripta(3,true,"Ciao a tutti!!!");
        System.out.println(resp);
        resp = cdc.criptaDecripta(3,false,"Fldr d wxwwl$$$");
        System.out.println(resp);
    }

    /* se op è true cripta, se false decripta */
    private String criptaDecripta(int key, boolean op, String word){
        String ret = "";
        for(int i=0; i<word.length();i++){
            char tmp = word.charAt(i);
            if(tmp != ' '){
                if(op) ret += (char)(tmp+key); /*cripta*/
                else ret += (char)(tmp-key); /*decripta*/
            }else ret += ' ';
        }
        return ret;
    }
}
