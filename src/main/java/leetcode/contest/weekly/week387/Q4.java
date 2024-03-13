package leetcode.contest.weekly.week387;

import org.junit.Test;

import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.DelayQueue;

public class Q4 {
    DecimalFormat df = new DecimalFormat("0000000000");

    public int[] resultArray(int[] nums) {
        Deque<Integer> deque1 = new ArrayDeque<>();
        TreeNode root1 = new TreeNode();
        Deque<Integer> deque2 = new ArrayDeque<>();
        TreeNode root2 = new TreeNode();

        deque1.addFirst(nums[0]);
        appendNumInRoot(root1, nums[0]);
        deque2.addFirst(nums[1]);
        appendNumInRoot(root2, nums[1]);

        for (int i = 2; i < nums.length; i++) {
            if (calculateHowManyNumsLargerThanANum(root1, nums[i]) > calculateHowManyNumsLargerThanANum(root2, nums[i])) {
                deque1.addLast(nums[i]);
                appendNumInRoot(root1, nums[i]);
            } else if (calculateHowManyNumsLargerThanANum(root1, nums[i]) < calculateHowManyNumsLargerThanANum(root2, nums[i])) {
                deque2.addLast(nums[i]);
                appendNumInRoot(root2, nums[i]);
            } else {
                if (deque1.size() <= deque2.size()) {
                    deque1.addLast(nums[i]);
                    appendNumInRoot(root1, nums[i]);
                } else {
                    deque2.addLast(nums[i]);
                    appendNumInRoot(root2, nums[i]);
                }
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

    private class TreeNode {
        int count;
        TreeNode[] children;

        TreeNode() {
            count = 0;
            children = new TreeNode[10];
        }
    }

    private void appendNumInRoot(TreeNode root, int num) {
        root.count++;
        String s = changeToANumWithPrefixZero(num);
        TreeNode curNode = root;
        for (char c : s.toCharArray()) {
            if (curNode.children[c - '0'] == null) {
                curNode.children[c - '0'] = new TreeNode();
            }
            curNode = curNode.children[c - '0'];
            curNode.count++;
        }
    }

    private int calculateHowManyNumsLargerThanANum(TreeNode root, int num) {
        int largerThanCount = 0;
        String s = changeToANumWithPrefixZero(num);
        TreeNode curNode = root;
        for (char c : s.toCharArray()) {
            if (curNode == null) {
                break;
            }
            for (int i = c - '0' + 1; i <= 9; i++) {
                largerThanCount += curNode.children[i] == null ? 0 : curNode.children[i].count;
            }
            curNode = curNode.children[c - '0'];
        }
        return largerThanCount;
    }


    private String changeToANumWithPrefixZero(int num) {
        String result = df.format(num);
        return result;
    }

//    @Test
//    public void test() {
//        String s = changeToANumWithPrefixZero(9213);
//        System.out.println(s);
//    }
}
