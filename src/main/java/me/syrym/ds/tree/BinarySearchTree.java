package me.syrym.ds.tree;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BinarySearchTree<E extends Comparable<E>> {
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

    public boolean contains(E obj) {
        return contains(obj, root);
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

    private boolean contains(E obj, Node<E> node) {
        if (node == null) {
            return false;
        }

        if (obj.compareTo(node.value) == 0) {
            return true;
        }

        if (obj.compareTo(node.value) > 0) {
            return contains(obj, node.right);
        }

        return contains(obj, node.left);
    }

    protected Node<E> leftRotate(Node<E> node) {
        Node<E> temp = node.right;
        node.right = temp.left;
        temp.left = node.right;
        return temp;
    }

    protected Node<E> rightRotate(Node<E> node) {
        Node<E> temp = node.left;
        node.left = temp.right;
        temp.right = node.left;
        return temp;
    }

    protected Node<E> rightLeftRotate(Node<E> node) {
        node.right = rightRotate(node.right);
        return leftRotate(node);
    }

    protected Node<E> leftRightRotate(Node<E> node) {
        node.left = leftRotate(node.left);
        return rightRotate(node);
    }
}
