package it.corsobackendtree.esercizi2;

public class SommaDiagonale {
    public static void main(String[] args){
        int[][] matrice = {{1,7,0,-1},{-1,3,8,5},{2,0,-2,4},{6,1,5,9}};
        int[][] matrice2 = {{2,0,0,1},{0,2,1,0},{0,1,2,0},{1,0,0,2}};
        SommaDiagonale sd = new SommaDiagonale();
        try {
            int resp = sd.sommaDiag(matrice,0); /*0 => SxDx*/
            System.out.println(resp);
            resp = sd.sommaDiag(matrice,1); /*1 => DxSx*/
            System.out.println(resp+"\n");

            int resp2 = sd.sommaDiag(matrice2,0); /*0 => SxDx*/
            System.out.println(resp2);
            resp2 = sd.sommaDiag(matrice2,1); /*1 => DxSx*/
            System.out.println(resp2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int sommaDiag(int[][] matrice, int op) throws Exception {
        int dimensioneRighe = matrice.length;
        int dimensioneColonne = matrice[0].length;
        if(dimensioneRighe != dimensioneColonne){
            throw new Exception("La matrice non è una matrice quadrata!");
        }
        int ret = 0;
        int currentCol;
        if(op == 0){
            currentCol = 0;
        }else{
            currentCol = dimensioneRighe-1;
        }
        for(int i=0; i<dimensioneRighe; i++){
            ret += matrice[i][currentCol];
            if(op == 0){
                currentCol++;
            }else{
                currentCol--;
            }
        }
        return ret;
    }
}
