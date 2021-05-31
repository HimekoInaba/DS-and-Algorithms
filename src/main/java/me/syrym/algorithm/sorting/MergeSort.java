package me.syrym.algorithm.sorting;

public class MergeSort {
    public static void start(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            mergeSort(arr, lo, mid);
            mergeSort(arr, mid + 1, hi);
            merge(arr, lo, mid, hi);
        }
    }

    private static void merge(int[] arr, int lo, int mid, int hi) {
        int n = mid - lo + 1;
        int m = hi - mid;
        int[] f  = new int[n];
        int[] s  = new int[m];
        for (int i = 0; i < n; i++) {
            f[i] = arr[lo + i];
        }
        for (int i = 0; i < m; i++) {
            s[i] = arr[mid + 1 + i];
        }
        int i = 0, j = 0;
        int k = lo;
        while (i < n && j < m) {
            if (f[i] <= s[j]) {
                arr[k++] = f[i++];
            } else {
                arr[k++] = s[j++];
            }
        }
        while (i < n) {
            arr[k++] = f[i++];
        }
        while (j < m) {
            arr[k++] = s[j++];
        }
    }
}
