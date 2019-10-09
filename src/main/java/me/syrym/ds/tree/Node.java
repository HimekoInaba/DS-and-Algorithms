package me.syrym.ds.tree;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Node<E extends Comparable<E>> {
    private E value;
    private Node left;
    private Node right;

    public Node(E value) {
        this.value = value;
    }
}
