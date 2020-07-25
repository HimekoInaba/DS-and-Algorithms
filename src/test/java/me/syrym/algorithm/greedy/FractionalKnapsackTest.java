package me.syrym.algorithm.greedy;

import org.junit.Assert;
import org.junit.Test;

public class FractionalKnapsackTest {

    @Test
    public void testKnapsack() {
        FractionalKnapsack fractionalKnapsack = new FractionalKnapsack();
        FractionalKnapsack.Item[] arr = new FractionalKnapsack.Item[]{
                new FractionalKnapsack.Item(2, 2.0),
                new FractionalKnapsack.Item(3, 2.5),
                new FractionalKnapsack.Item(4, 3.0),
                new FractionalKnapsack.Item(5, 3.5),
        };
        double res = fractionalKnapsack.fitMaxVolume(arr, 11);
        Assert.assertEquals(24.9, res, 0.1);
    }
}
