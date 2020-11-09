package it.corsobackendtree.esercizi12;

public class Main {
    public static void main(String[] args) {
        //test(new CodaSupermercatoPriorityQueue()); /*PriorityQueue*/
        test(new CodaSupermercatoTreeSet()); /*TreeSet - soluzione migliore per complessità nella gestione dei duplicati!*/
    }

    private static void test(SupermarketQueue cs){
        Cliente marco = new Cliente("Marco","Bianchi",58);
        Cliente alessio = new Cliente("Alessio","Verdi",32);
        Cliente federica = new Cliente("Federica","Neri",32);
        Cliente michele = new Cliente("Michele","Rossi", 72);
        Cliente angela = new Cliente("Angela","Bianchi",18);

        cs.arrivaCliente(marco);
        cs.arrivaCliente(alessio);
        cs.arrivaCliente(federica);
        cs.arrivaCliente(michele);
        cs.arrivaCliente(angela);

        System.out.println(( cs.arrivaCliente(federica) == false ) + "\n"); /*La coda non ammette clienti duplicati (ovvero con lo stesso id)!*/

        System.out.println(cs.getNClientiInCoda() == 5);
        System.out.println(cs.whoIsNext().getEta() == 72);
        cs.clienteInCassa();
        System.out.println(cs.whoIsNext().getEta() == 58);
        cs.clienteInCassa();
        System.out.println(cs.whoIsNext().getEta() == 32);
        cs.clienteInCassa();
        System.out.println(cs.whoIsNext().getEta() == 32);
        cs.clienteInCassa();
        System.out.println(cs.whoIsNext().getEta() == 18);
        cs.clienteInCassa();
        System.out.println(cs.getNClientiInCoda() == 0);
    }
}
