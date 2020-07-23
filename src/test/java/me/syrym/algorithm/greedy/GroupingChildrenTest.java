package me.syrym.algorithm.greedy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class GroupingChildrenTest {
    private GroupingChildren groupingChildren;

    @Before
    public void setup() {
        groupingChildren = new GroupingChildren();
    }

    @Test
    public void groupChildrenTest() {
        Set<Set<Integer>> result = groupingChildren.groupChildrenByAge(new int[]{5, 6, 9, 11}, 1);
        Assert.assertEquals(3, result.size());
    }
}
