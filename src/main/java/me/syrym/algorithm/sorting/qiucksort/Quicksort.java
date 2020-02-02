package me.syrym.algorithm.sorting.qiucksort;

public class Quicksort {
    public static void start(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }

    private static void quicksort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotFinalRestingPosition = partition(arr, left, right);

            quicksort(arr, left, pivotFinalRestingPosition - 1);
            quicksort(arr, pivotFinalRestingPosition + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, right);

        return i + 1;
    }

    private static void swap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }
}
