package leetcode.contest.weekly.week388;

import org.junit.Test;

public class Q4 {
    public long maximumStrength(int[] nums, int k) {
        int n = nums.length;
        long[][] dp = new long[n + 1][k + 1];
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        for (int j = 1; j <= k; j++) {
            dp[j - 1][j] = Long.MIN_VALUE;
            long middleExpressionMax = Long.MIN_VALUE;
            int w = j % 2 == 0 ? -(k - j + 1) : (k - j + 1);
            for (int i = j; i <= n - k + j; i++) {
                middleExpressionMax = Math.max(middleExpressionMax, dp[i - 1][j - 1] - prefixSum[i - 1] * w);
                dp[i][j] = Math.max(dp[i - 1][j], w * prefixSum[i] + middleExpressionMax);
            }
        }
        return dp[n][k];
    }

    @Test
    public void test() {
        int[] nums = {1,2,3,-1,2};
        int k = 3;
        long l = maximumStrength(nums, k);
        System.out.println(l);
    }

}
