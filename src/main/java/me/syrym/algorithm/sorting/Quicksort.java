package me.syrym.algorithm.sorting;

public class Quicksort {
    public static void start(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }

    private static void quicksort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotFinalRestingPosition = partition(arr, left, right);

            quicksort(arr, left, pivotFinalRestingPosition);
            quicksort(arr, pivotFinalRestingPosition + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[left + (right-left) / 2];
        int i = left;
        int j = right;

        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(arr, i++, j--);
        }

        return j;
    }

    private static void swap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }
}
