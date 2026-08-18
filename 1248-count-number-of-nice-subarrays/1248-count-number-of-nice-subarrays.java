class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atmost(nums,k)-atmost(nums,k-1);
    }
    private int atmost(int [] nums,int k){
        int left=0;
        int oddCount=0;
        int len=0;
        for(int i =0;i<nums.length;i++){
            if(nums[i]%2==1){
                oddCount++;
            }
            while(oddCount>k){
                if(nums[left]%2==1){
                    oddCount--;
                }
                left++;
            }
            len+=i-left+1;
        }
        return len;
    }
}