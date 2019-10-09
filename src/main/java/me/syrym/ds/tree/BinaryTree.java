package me.syrym.ds.tree;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class BinaryTree<E extends Comparable<E>> {
    @Getter
    private Node head;
}
