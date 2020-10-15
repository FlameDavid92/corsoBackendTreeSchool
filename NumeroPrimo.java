package it.corsobackendtree;

public class NumeroPrimo {
    public static void main(String[] args) {
        int number = 0;
        System.out.println(isPrime(number));
        number = 1;
        System.out.println(isPrime(number));
        number = 2;
        System.out.println(isPrime(number));
        number = 17;
        System.out.println(isPrime(number));
        number = 631;
        System.out.println(isPrime(number));
        number = 634;
        System.out.println(!isPrime(number));
        number = 999;
        System.out.println(!isPrime(number));
        number = 997;
        System.out.println(isPrime(number));
    }

    /**
     * Metodo isPrime(String s)
     *
     * input: un intero number.
     * output: ritorna il boolean true se l'intero in input è un numero primo, false altrimenti.
     */
    private static boolean isPrime(int number) {
        if (number <= 1) return false; /* 0 e 1 non sono primi!!! */
        if (number==2 || number==3){
            return true;
        }
        if ((number % 2) == 0){
            return false;
        }
        int c = 3;
        while (c <= Math.sqrt(number)){
            if ( (number % c) == 0){
                return false;
            }
            c = c + 2;
        };
        return true;
    }
}
