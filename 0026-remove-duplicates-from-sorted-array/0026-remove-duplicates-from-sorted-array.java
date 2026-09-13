class Solution {
    public int removeDuplicates(int[] nums) {
        int left =0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!hm.containsKey(nums[i])){
                hm.put(nums[i],1);
                nums[left]=nums[i];
                left++;
            }
        }
        return left;
    }
}