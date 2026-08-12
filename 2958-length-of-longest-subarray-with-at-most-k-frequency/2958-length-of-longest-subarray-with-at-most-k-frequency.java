class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        if(nums.length==0 || k==0){
            return 0;
        }
        int left=0;
        int max=Integer.MIN_VALUE;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int right=0;right<nums.length;right++){
            hm.put(nums[right],hm.getOrDefault(nums[right],0)+1);
            while(hm.get(nums[right])>k){
                int n=hm.get(nums[left])-1;
                hm.put(nums[left],n);
                left++;
            }
            max=Math.max(right-left+1,max);
        }
        return max;
        
    }
}