package me.syrym.ds.list;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.NoSuchElementException;

@NoArgsConstructor
public class LinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    @Getter
    private int size;

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E e) {
            this.data = e;
        }
    }

    public LinkedList(E e) {
        head = new Node<E>(e);
        size++;
    }

    public void addFirst(E e) {
        Node<E> node = new Node<E>(e);

        if (head == null) {
            head = tail = node;
            size++;
            return;
        }

        node.next = head;
        head = node;
        size++;
    }

    public void addLast(E e) {
        Node<E> node = new Node<E>(e);

        if (head == null) {
            head = tail = node;
            size++;
            return;
        }

        Node<E> temp = tail;
        tail = node;
        temp.next = tail;
        size++;
    }

    public E getFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        return head.data;
    }

    public E getLast() {
        if (tail == null) {
            throw new NoSuchElementException();
        }
        return tail.data;
    }
}
