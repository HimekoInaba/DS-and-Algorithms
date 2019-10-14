package me.syrym.ds.list;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {
    private LinkedList<Integer> list;

    @Before
    public void setup() {
        list = new LinkedList<Integer>();
    }

    @Test
    public void addFirstTest_ifHeadIsNull() {
        list.addFirst(1);
        Assert.assertEquals(1, list.getSize());
        Assert.assertEquals(new Integer(1), list.getFirst());
    }

    @Test
    public void addLastTest_ifHeadIsNull() {
        list.addLast(1);
        Assert.assertEquals(1, list.getSize());
        Assert.assertEquals(new Integer(1), list.getLast());
    }

    @Test
    public void addFirstTest_ifHeadIsNotNull() {
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        Assert.assertEquals(3, list.getSize());
        Assert.assertEquals(new Integer(1), list.getLast());
        Assert.assertEquals(new Integer(3), list.getFirst());
    }

    @Test
    public void addLastTest_ifHeadIsNotNull() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        Assert.assertEquals(3, list.getSize());
        Assert.assertEquals(new Integer(1), list.getFirst());
        Assert.assertEquals(new Integer(3), list.getLast());
    }

    @Test
    public void removeFirstTest() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        Integer removed = list.removeFirst();
        Assert.assertEquals(new Integer(1), removed);
    }

    @Test
    public void removeLastTest() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        Integer removed = list.removeLast();
        Assert.assertEquals(new Integer(3), removed);
    }

    @Test
    public void removeTest() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        Integer removed = list.remove(3);
        Assert.assertEquals(new Integer(3), removed);
    }

    @Test
    public void containsTest_whenElementIsPresent() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        Assert.assertTrue(list.contains(3));
    }

    @Test
    public void containsTest_whenElementIsNotPresent() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        Assert.assertFalse(list.contains(8));
    }
}
