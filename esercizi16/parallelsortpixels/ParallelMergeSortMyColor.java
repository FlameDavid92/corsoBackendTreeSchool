package it.corsobackendtree.esercizi16.parallelsortpixels;

import java.util.concurrent.RecursiveAction;

/* Java program for Merge Sort */
class ParallelMergeSortMyColor extends RecursiveAction {
    private static final long serialVersionUID = 2233822280936871158L;
    private final MyColor[] array;
    private final int low;
    private final int high;
    private static final int MAX = 16384; /*CUTOFF sequenziale*/
    //private static final int MAX = 8192;
    //private static final int MAX = 4096;
    //private static final int MAX = 2048;

    public ParallelMergeSortMyColor(final MyColor[] array, final int low, final int high) {
        this.array = array;
        this.low = low;
        this.high = high;
    }

    @Override
    protected void compute() {
        if (low < high) {
            if (high - low <= MAX) {
                // Implementazione sequenziale
                sort(array, low, high);
            } else {
                // Implementazione parallela
                final int middle = (low + high) / 2;
                final ParallelMergeSortMyColor left =
                        new ParallelMergeSortMyColor(array, low, middle);
                final ParallelMergeSortMyColor right =
                        new ParallelMergeSortMyColor(array, middle + 1, high);
                invokeAll(left, right);
                merge(array, low, middle, high);
            }
        }
    }

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    private static void merge(MyColor[] arr, int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        MyColor[] L = new MyColor[n1];
        MyColor[] R = new MyColor[n2];

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

            if (L[i].compareTo(R[j]) == -1) {
                arr[k] = L[i];
                i++;
            } else {
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
    private static void sort(MyColor[] arr, int l, int r) {
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