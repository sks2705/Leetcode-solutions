class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int prefix = 1, suffix = 1;
        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (prefix == 0) prefix = 1;
            if (suffix == 0) suffix = 1;

            prefix *= nums[i];
            suffix *= nums[n - 1 - i];

            answer = Math.max(answer, Math.max(prefix, suffix));
        }

        return answer;
    }
}