package leetcode.contest.weekly.week388;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q2 {
    public long maximumHappinessSum(int[] happiness, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
        for (int h : happiness) {
            priorityQueue.add(h);
        }
        long sum = 0;
        for (int i = 0; i < k; i++) {
            sum += Math.max(0, priorityQueue.poll() - i);
        }
        return sum;
    }
}
