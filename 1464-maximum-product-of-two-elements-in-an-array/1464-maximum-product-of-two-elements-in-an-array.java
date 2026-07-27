class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int length=nums.length;
        int max=(nums[length-1]-1)*(nums[length-2]-1);
        return max;
        
    }
}