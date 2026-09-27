import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        int longest =0;
        HashSet<Integer> hs= new HashSet<>();
        for(int i =0;i<nums.length;i++){
            hs.add(nums[i]);
        }
        for(int num:hs){
            if(!hs.contains(num-1)){
                int current = num;
                int count=1;
                while(hs.contains(current+1)){
                    count++;
                    current++;
                }
                longest=Math.max(count,longest);
            }
        }
        return longest;
    }
}