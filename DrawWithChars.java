package it.corsobackendtree;

public class DrawWithChars {
    public static void main(String[] args){
        DrawWithChars dwc = new DrawWithChars();
        //dwc.draw1(10);
        dwc.draw2(10);
    }

    private void draw1(int n){
        System.out.println("-".repeat(n+2));
        boolean isEven = (n%2 == 0);
        for(int i=1; i<=n; i++){
            System.out.print("|");
            if(i % 2 != 0){
                System.out.print("# ".repeat(n/2));
                if(!isEven) System.out.print("#");
            } else {
                System.out.print(" #".repeat(n/2));
                if(!isEven) System.out.print(" ");
            }
            System.out.println("|");
        }
        System.out.println("-".repeat(n+2));
    }


    private void printDashes(int m){
        for(int i=1; i<=m; i++){
            if(i == m){
                System.out.println('-');
            }else{
                System.out.print('-');
            }
        }
    }
    private void draw2(int n){
        printDashes(n+2);
        for(int i=1; i<=n; i++){
            System.out.print('|');
            for(int j=1; j<=n; j++){
                if(i%2 != 0){ /* siamo in una riga dispari */
                    if(j%2 != 0){ /* siamo in una colonna dispari */
                        System.out.print('#');
                    }else System.out.print(' '); /* siamo in una colonna pari */
                }else{ /*siamo in una riga pari */
                    if(j%2 != 0){ /* siamo in una colonna dispari */
                        System.out.print(' ');
                    }else System.out.print('#'); /* siamo in una colonna pari */
                }
            }
            System.out.println('|');
        }
        printDashes(n+2);
    }
}
