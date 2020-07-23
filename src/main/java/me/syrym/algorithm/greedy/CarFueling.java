package me.syrym.algorithm.greedy;

public class CarFueling {

    public int travel(int[] arr, int volume) {
        int n = arr.length;
        int numRefills = 0;
        int currentRefill = 0;

        while (currentRefill <= n) {
            int lastRefill = currentRefill;

            while (currentRefill <= n && arr[currentRefill + 1] - arr[lastRefill] <= volume) {
                currentRefill++;
            }

            if (currentRefill == lastRefill) {
                return -1;
            }

            if (currentRefill <= n) {
                numRefills++;
            }
        }

        return numRefills;
    }
}
