package it.corsobackendtree;

public class Armonica {
    public static void main(String[] args) {
        System.out.println(recursiveHarmonicSum(0) == (0));
        System.out.println(recursiveHarmonicSum(1) == (1));
        System.out.println(recursiveHarmonicSum(2) == (3./2));
        System.out.println(recursiveHarmonicSum(20) == (55835135./15519504));
        System.out.println("\n");
        System.out.println(harmonicSum(0) == (0));
        System.out.println(harmonicSum(1) == (1));
        System.out.println(harmonicSum(2) == (3./2));
        System.out.println(harmonicSum(20) == (55835135./15519504));
    }

    /**
     * Metodo harmonicSum(int n)
     *
     * input: un intero n.
     * output: un double il cui valore è quello della serie armonica di n.
     */
    private static double harmonicSum(int n) {
        double ret = 0;
        for(double i=n; i>=1; i--){
            ret += (1/i);
        }
        return ret;
    }

    /* Versione ricorsiva */
    private static double recursiveHarmonicSum(double n) {
        if(n==0){
            return 0;
        }
        else if(n==1){
            return 1;
        }
        return (1D/n)+recursiveHarmonicSum(n-1);
    }
}
