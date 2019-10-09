package me.syrym.ds.heap;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap<E extends Comparable<E>> {
    private List<E> elements;
    private int lastPos;

    public MaxHeap(int initialSize) {
        this.elements = new ArrayList<E>(initialSize);
    }

    public MaxHeap() {
        elements = new ArrayList<E>();
    }

    public void add(E obj) {
        elements.add(++lastPos, obj);
        trickleUp(lastPos);
    }

    private void trickleUp(int pos) {
        if (pos == 0) {
            return;
        }

        int parent = (int) Math.floor((pos - 1) / 2.0);

        if (elements.get(pos).compareTo(elements.get(parent)) > 0) {
            swap(pos, parent);
            trickleUp(parent);
        }
    }

    private void swap(int pos, int parent) {
        E temp = elements.get(parent);
        elements.set(parent, elements.get(pos));
        elements.set(pos, temp);
    }
}
