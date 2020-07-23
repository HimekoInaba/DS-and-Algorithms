package me.syrym.algorithm.greedy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GroupingChildren {

    public Set<Set<Integer>> groupChildrenByAge(int[] children, int allowedAgeDiff) {
        Arrays.sort(children);
        Set<Set<Integer>> grouped = new HashSet<>();
        int pointer = 0;
        int size = children.length;

        while (pointer < size) {
            int l = children[pointer];
            int r = l + allowedAgeDiff;
            Set<Integer> group = new HashSet<>();
            group.add(l);

            while (pointer < size && children[pointer] <= r) {
                group.add(children[pointer]);
                pointer++;
            }
            grouped.add(group);
        }

        return grouped;
    }
}
