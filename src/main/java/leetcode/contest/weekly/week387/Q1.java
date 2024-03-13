package leetcode.contest.weekly.week387;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Q1 {
    public int[] resultArray(int[] nums) {
        Deque<Integer> deque1 = new ArrayDeque<>();
        Deque<Integer> deque2 = new ArrayDeque<>();
        deque1.addFirst(nums[0]);
        deque2.addFirst(nums[1]);
        for (int i = 2; i < nums.length; i++) {
            if (deque1.getLast() > deque2.getLast()) {
                deque1.addLast(nums[i]);
            } else {
                deque2.addLast(nums[i]);
            }
        }
        int[] result = new int[nums.length];
        int idx = 0;
        while (!deque1.isEmpty()) {
            result[idx] = deque1.removeFirst();
            idx++;
        }
        while (!deque2.isEmpty()) {
            result[idx] = deque2.removeFirst();
            idx++;
        }
        return result;
    }
}
