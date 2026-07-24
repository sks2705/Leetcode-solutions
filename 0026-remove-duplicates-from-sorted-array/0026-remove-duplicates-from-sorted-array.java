class Solution {
    public int removeDuplicates(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int left=0;
        for(int i =0;i<nums.length;i++){
            if(!hm.containsKey(nums[i])){
                hm.put(nums[i],1);
                nums[left]=nums[i];
                left++;
            }
        }
        return left;
    }
}