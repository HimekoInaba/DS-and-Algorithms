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

    /**
     * removes root (max element) and returns it
     * @return root
     */
    public E remove() {
        E root = elements.get(0);
        swap(0, lastPos--);
        trickleDown(0);
        return root;
    }

    private void trickleDown(int parentPos) {
        int left = 2 * parentPos + 1;
        int right = 2 * parentPos + 2;

        if (left == lastPos && elements.get(left).compareTo(elements.get(parentPos)) > 0) {
            swap(left, parentPos);
            return;
        }

        if (right == lastPos && elements.get(right).compareTo(elements.get(parentPos)) > 0) {
            swap(right, parentPos);
            return;
        }

        if (right >= lastPos || left >= lastPos) {
            return;
        }

        if (elements.get(left).compareTo(elements.get(parentPos)) > 0) {
            swap(left, parentPos);
            trickleDown(left);
        } else if (elements.get(right).compareTo(elements.get(parentPos)) > 0) {
            swap(right, parentPos);
            trickleDown(right);
        }
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
