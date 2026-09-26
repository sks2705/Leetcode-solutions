class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer>hm = new HashMap<>();
        for(int i:nums){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        for(int i =0;i<nums.length;i++){
            if(hm.get(nums[i])==1){
                return nums[i];
            }
        }
        return -1;
    }
}