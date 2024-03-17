package leetcode.contest.weekly.week388;

import java.util.Arrays;

public class Q1 {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = Arrays.stream(apple).sum();
        Arrays.sort(capacity);
        int curCapacity = 0;
        for (int i = capacity.length - 1; i >= 0; i--) {
            curCapacity += capacity[i];
            if (curCapacity >= sum) {
                return capacity.length - i;
            }
        }
        return -1;
    }
}
