class Solution {
    public int largestInteger(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n = nums.length;
        
        if(n==k){
            int max=Integer.MIN_VALUE;
            for(int num:nums){
                max=Math.max(max,num);
            }
            return max;
        }

        for(int num:nums){
            hm.put(num,hm.getOrDefault(num,0)+1);
        }

        if(k==1){
            int max=-1;
            for(int key:hm.keySet()){
                if(hm.get(key)==1){
                    max=Math.max(max,key);
                }
            }
            return max;
        }
        int ans=-1;

        if(hm.get(nums[0])==1){
            ans=nums[0];
        }

        if(hm.get(nums[n-1])==1){
            ans=Math.max(ans,nums[n-1]);
        }
        return ans;
    }
}