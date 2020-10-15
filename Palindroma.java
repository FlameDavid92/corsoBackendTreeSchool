package it.corsobackendtree;

public class Palindroma {
    public static void main(String[] args) {
        System.out.println(isPalindrome("c"));
        System.out.println(isPalindrome("ciic"));
        System.out.println(isPalindrome("aaaa"));
        System.out.println(!isPalindrome("absca"));
        System.out.println(!isPalindrome("abbaa"));
        System.out.println(isPalindrome("zzzzz"));
        System.out.println(isPalindrome("zzczz"));
        System.out.println(isPalindrome("aabbaa"));
        System.out.println("-------------------------");
        System.out.println(isPalindrome2("c"));
        System.out.println(isPalindrome2("ciic"));
        System.out.println(isPalindrome2("aaaa"));
        System.out.println(!isPalindrome2("absca"));
        System.out.println(!isPalindrome2("abbaa"));
        System.out.println(isPalindrome2("zzzzz"));
        System.out.println(isPalindrome2("zzczz"));
        System.out.println(isPalindrome2("aabbaa"));
    }

    /**
     * Metodo isPalindrome(String s)
     *
     * input: una stringa s.
     * output: ritorna il boolean true se la stringa s è palindroma, false altrimenti.
     */
    private static boolean isPalindrome(String s) {
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i) != s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;
    }

    /* Versione ricorsiva */
    private static boolean isPalindrome2(String s) {
        /*Per passare la stringa s per referenza al metodo ricorsivo
         mi creo l'oggetto StringBuffer sulla stringa s*/
        StringBuffer sb = new StringBuffer(s);
        return recursivePalindrome(sb,s.length()/2);
    }

    private static boolean recursivePalindrome(StringBuffer sb, int n){
        if(n == -1){
            return true;
        }
        if(sb.charAt(n) != sb.charAt(sb.length()-n-1)){
            return false;
        }else{
            return recursivePalindrome(sb, n-1);
        }
    }
    /*--------------------*/
}
