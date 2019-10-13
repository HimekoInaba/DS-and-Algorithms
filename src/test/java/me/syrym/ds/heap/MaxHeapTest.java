package me.syrym.ds.heap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MaxHeapTest {
    private MaxHeap<Integer> heap;
    private List<Integer> sorted;

    @Before
    public void setup() {
        heap = new MaxHeap<Integer>(4);
        sorted = new ArrayList<Integer>();

        heap.add(6);
        heap.add(2);
        heap.add(15);
        heap.add(9);
        heap.add(5);
        heap.add(11);
        heap.add(3);

        sorted.add(2);
        sorted.add(3);
        sorted.add(4);
        sorted.add(5);
        sorted.add(6);
        sorted.add(9);
        sorted.add(11);
        sorted.add(15);
    }

    @Test
    public void heapSortTest() {
        Assert.assertEquals(sorted, heap.heapSort());
    }
}
