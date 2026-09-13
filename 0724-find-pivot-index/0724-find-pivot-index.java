class Solution {
    public int pivotIndex(int[] nums) {
       int totalSum=0;
       for(int i =0;i<nums.length;i++){
        totalSum+=nums[i];
       } 
       int sum=0;
       int rightSum=0;
       for(int i =0;i<nums.length;i++){
        rightSum=totalSum-sum-nums[i];
        if(rightSum==sum){
            return i;
        }
        sum+=nums[i];
       }
       return -1;
    }
}