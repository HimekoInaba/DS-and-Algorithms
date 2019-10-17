package me.syrym.ds.tree;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BinaryTree<E extends Comparable<E>> {
    private Node<E> root;

    private static class Node<E extends Comparable<E>> {
        E value;
        Node<E> left;
        Node<E> right;

        Node(E value) {
            this.value = value;
        }
    }

    public void add(E obj) {
        if (root == null) {
            root = new Node<>(obj);
            return;
        }
        add(obj, root);
    }

    private void add(E obj, Node<E> node) {
        if (node.value.compareTo(obj) < 0) {
            if (node.right == null) {
                node.right = new Node<>(obj);
                return;
            }
            add(obj, node.right);
            return;
        }

        if (node.left == null) {
            node.left = new Node<>(obj);
            return;
        }

        add(obj, node.left);
    }
}
