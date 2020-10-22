package it.corsobackendtree.esercizi3;

public class TrovaNumeriPerfetti {
    public static void main(String[] args) {
        perfectsLessEqualThan1000();
        System.out.println("--------------------");
        TrovaNumeriPerfetti tnp = new TrovaNumeriPerfetti();
        tnp.perfectsLessEqualThan1000v2();
    }

    public static boolean isPerfect(int n) {
        int temp = 1;
        int c = n;
        for (int i = 2; i < n; i++) {
            if (c % i == 0) {
                temp += i;
                if (temp > n) break;
            }
        }
        return temp == n && temp != 1;
    }

    public static void perfectsLessEqualThan1000() {
        for (int i = 1; i <= 1000; i++) {
            if (isPerfect(i)) {
                System.out.println(i + " è perfetto!");
            }
        }
    }

    /*I numeri perfetti inferiori a 1000 sono tre e sono 6, 28 e 496 e sono tutti pari.
     * Euclide ha dimostrato che 2^(p-1) * (2^p - 1) con p primo da sempre un numero perfetto pari.
     * I primi tre numeri perfetti è possibile trovarli con le formule:
     * 2^1 * (2^2 -1) => p=2
     * 2^2 * (2^3 -1) => p=3
     * 2^4 * (2^5 -1) => p=5
     */
    private void perfectsLessEqualThan1000v2() {
        System.out.println(Math.round(Math.pow(2, 1) * (Math.pow(2, 2) - 1)) + " è perfetto!");
        System.out.println(Math.round(Math.pow(2, 2) * (Math.pow(2, 3) - 1)) + " è perfetto!");
        System.out.println(Math.round(Math.pow(2, 4) * (Math.pow(2, 5) - 1)) + " è perfetto!");
    }

}
