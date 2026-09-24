class Solution {
    public int smallestIndex(int[] nums) {
        for(int i =0;i<nums.length;i++){
            int sum=0;
            if(nums[i]<10 && nums[i]==i){
                return i;
            }
            else{
                int n=nums[i];
                while(n>0){
                    int rem=n%10;
                    sum+=rem;
                    n=n/10;
                }
            }
            
            if(sum==i){
                return i;
            }

        } 
        return -1;  
    }
}