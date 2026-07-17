import java.util.Arrays;

class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int maxNum = 0;
        for (int num : nums) {
            if (num > maxNum) {
                maxNum = num;
            }
        }
        long[] counts = new long[maxNum + 1];
        for (int num : nums) {
            counts[num]++;
        }
        long[] gcdPairs = new long[maxNum + 1];
        for (int i = maxNum; i >= 1; i--) {
            long totalMultiples = 0;
            for (int j = i; j <= maxNum; j += i) {
                totalMultiples += counts[j];
            }

            long pairs = (totalMultiples * (totalMultiples - 1)) / 2;

            for (int j = 2 * i; j <= maxNum; j += i) {
                pairs -= gcdPairs[j];
            }
            
            gcdPairs[i] = pairs;
        }

        long[] prefixSums = new long[maxNum + 1];
        for (int i = 1; i <= maxNum; i++) {
            prefixSums[i] = prefixSums[i - 1] + gcdPairs[i];
        }
        int[] ans = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            ans[q] = binarySearch(prefixSums, queries[q]);
        }
        
        return ans;
    }
    private int binarySearch(long[] prefixSums, long target) {
        int low = 1;
        int high = prefixSums.length - 1;
        int result = high;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (prefixSums[mid] > target) {
                result = mid;      
                high = mid - 1;
            } else {
                low = mid + 1;      
            }
        }
        return result;
    }
}
