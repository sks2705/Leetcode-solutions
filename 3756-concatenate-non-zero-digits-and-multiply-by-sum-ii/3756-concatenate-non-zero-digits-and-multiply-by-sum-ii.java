import java.util.Arrays;

public class Solution {
    private static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int m = s.length();
        int q = queries.length;
        int[] answer = new int[q];

        int[] nonZeroCount = new int[m + 1];
        long[] prefixVal = new long[m + 1];
        long[] prefixSum = new long[m + 1];
        long[] powerOf10 = new long[m + 1];
        
        powerOf10[0] = 1;
        for (int i = 1; i <= m; i++) {
            powerOf10[i] = (powerOf10[i - 1] * 10) % MOD;
        }

        for (int i = 0; i < m; i++) {
            int digit = s.charAt(i) - '0';
            
            nonZeroCount[i + 1] = nonZeroCount[i];
            prefixVal[i + 1] = prefixVal[i];
            prefixSum[i + 1] = prefixSum[i];

            if (digit != 0) {
                nonZeroCount[i + 1]++;
                prefixVal[i + 1] = (prefixVal[i] * 10 + digit) % MOD;
                prefixSum[i + 1] = (prefixSum[i] + digit) % MOD;
            }
        }

        for (int i = 0; i < q; i++) {
            int li = queries[i][0];
            int ri = queries[i][1];

            long sum = (prefixSum[ri + 1] - prefixSum[li] + MOD) % MOD;

            int nonZeroInRange = nonZeroCount[ri + 1] - nonZeroCount[li];

            if (nonZeroInRange == 0) {
                answer[i] = 0;
                continue;
            }

            long totalLeftValShifted = (prefixVal[li] * powerOf10[nonZeroInRange]) % MOD;
            long x = (prefixVal[ri + 1] - totalLeftValShifted + MOD) % MOD;

            answer[i] = (int) ((x * sum) % MOD);
        }

        return answer;
    }
}
