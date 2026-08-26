class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        int product =1;
        int left=0;
        int ans=0;
        if(k<=1) return ans;
        for(int i =0;i<nums.length;i++){
            product*=nums[i];
            while(product>=k){
                product/=nums[left];
                left++;
            }
            ans+=i-left+1;
        }
        return ans;
        
    }
}