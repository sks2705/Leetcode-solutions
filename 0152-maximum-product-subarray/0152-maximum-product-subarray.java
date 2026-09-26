class Solution {
    public int maxProduct(int[] nums) {
        int max= nums[0];
        int min=nums[0];
        int answer=nums[0];
        for(int i =1;i<nums.length;i++){
            int oldMax=max;
            int oldMin=min;
            max=Math.max(nums[i],Math.max(oldMax*nums[i],oldMin*nums[i]));
            min=Math.min(nums[i],Math.min(oldMin*nums[i],oldMax*nums[i]));
            answer=Math.max(max,answer);
        }
        return answer;
    }
}