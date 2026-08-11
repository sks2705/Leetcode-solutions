class Solution {
    public int missingInteger(int[] nums) {
        int sum = nums[0]; 
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] == 1) {
                sum += nums[i + 1];
            } else {
                break; 
            }
        }
        HashSet<Integer> hs = new HashSet<>();
        for (int num : nums) {
            hs.add(num);
        }
        while (hs.contains(sum)) {
            sum += 1;
        }
        
        return sum;
    }
}
