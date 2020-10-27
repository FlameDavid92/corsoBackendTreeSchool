package it.corsobackendtree.esercizi7.classificaseriea.classi;

import java.util.Random;

/* Java program for Merge Sort */
class MergeSortSquadre {
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    private static void merge(Squadra[] arr, int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        Squadra[] L = new Squadra[n1];
        Squadra[] R = new Squadra[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            boolean left = false;

            if (L[i].getPunteggio() < R[j].getPunteggio()) {
                left = true;
            } else if (L[i].getPunteggio() == R[j].getPunteggio()) {
                /*controllo la differenza reti generale*/
                if ((L[i].getGolFatti() - L[i].getGolSubiti()) > (R[j].getGolFatti() - R[j].getGolSubiti())) {
                    left = true;
                } else if ((L[i].getGolFatti() - L[i].getGolSubiti()) == (R[j].getGolFatti() - R[j].getGolSubiti())) {
                    /* è uguale pure la differenza reti -_-' */
                    Random rdm = new Random();
                    int sorteggio = rdm.nextInt(2);
                    if(sorteggio == 0) left=true;
                    else left = false;
                }else left = false;
            }else left = false;

            if(left){
                arr[k] = L[i];
                i++;
            }else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    public static void sort(Squadra[] arr, int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
}