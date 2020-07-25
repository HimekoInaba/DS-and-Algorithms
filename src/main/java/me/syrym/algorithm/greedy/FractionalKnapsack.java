package me.syrym.algorithm.greedy;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public double fitMaxVolume(Item[] arr, double capacity) {
        int i = 0;
        double res = 0;
        Arrays.sort(arr, maxItemsComparator());

        while (capacity != 0) {
            Item curr = arr[i];
            if (capacity > curr.size) {
                capacity -= curr.size;
                res += curr.size * curr.val;
            } else {
                res += curr.val / curr.size * capacity;
                capacity = 0;
            }
            i++;
        }

        return res;
    }

    private Comparator<Item> maxItemsComparator() {
        return (t1, t2) -> {
            double diff = (t2.val / t2.size) - (t1.val / t1.size);
            if (diff > 0) {
                return 1;
            } else if (diff == 0) {
                return 0;
            }
            return -1;
        };
    }

    @AllArgsConstructor
    public static final class Item {
        private final double size;
        private final double val;
    }
}
