package me.syrym.algorithm.sorting;

import org.junit.Assert;
import org.junit.Test;

public class QuicksortTest {

    @Test
    public void testQuicksort() {
        int[] arr = new int[]{2, 14, 223, 1, 53, 5423, 221, 33};
        int[] sorted = new int[]{1, 2, 14, 33, 53, 221, 223, 5423};
        Quicksort.start(arr);
        Assert.assertArrayEquals(arr, sorted);
    }
}
