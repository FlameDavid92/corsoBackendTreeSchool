package it.corsobackendtree.esercizi2;

public class Tombola {
    public static void main(String[] args){
        Tombola t = new Tombola();

        int[][] cartella = {{9,27,55,70,83},{11,39,57,73,85},{5,18,34,41,62}};
        int[] estratti = {9,27,56,79,40,39,34,62,41,83,5,18,90,85,3,8,4,31,57,88};
        int[] estrattiTombola = {9,27,55,70,83,11,39,57,73,85,5,18,34,41,62,1,2,3,4,6,};
        String resp = t.checkGame(cartella, estratti);
        System.out.println(resp+"\n\n");

        resp = t.checkGame(cartella, estrattiTombola);
        System.out.println(resp);
    }

    private String checkGame(int[][] cartella, int[] estratti){
        if(cartella.length != 3 || cartella[0].length != 5) return "Cartella non valida!";
        if(estratti.length < 20) return "Occorrono almeno 20 numeri estratti!";
        int[] righe = {0, 0, 0};
        for(int i=0; i<estratti.length; i++){ /*ciclo sull'array dei numeri estratti*/
            for(int j=0; j<5; j++){ /*ciclo sulle 5 colonne della cartella e controllo le 3 righe*/
                if(estratti[i] == cartella[0][j]){
                    righe[0]++;
                }else if(estratti[i] == cartella[1][j]){
                    righe[1]++;
                }else if(estratti[i] == cartella[2][j]){
                    righe[2]++;
                }
            }
            if(righe[0] == 5 && righe[1] == 5 && righe[2] == 5) return "TOMBOLA!!";
        }

        int ambi = 0, terni = 0, quaterne = 0, cinquine = 0;
        for(int c : righe){
            switch (c){
                case 2:
                    ambi++;
                    break;
                case 3:
                    terni++;
                    break;
                case 4:
                    quaterne++;
                    break;
                case 5:
                    cinquine++;
                    break;
            }
        }
        return "Il giocatore ha totalizzato\n"+
                ((ambi>0) ? ("ambi: "+ambi+"\n") : "")+
                ((terni>0) ? ("terni: "+terni+"\n") : "")+
                ((quaterne>0) ? ("quaterne: "+quaterne+"\n") : "")+
                ((cinquine>0) ? ("cinquine: "+cinquine) : "");
    }
}
