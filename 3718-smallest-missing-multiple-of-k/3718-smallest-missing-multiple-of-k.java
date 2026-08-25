import java.util.HashSet;

class Solution { 
    public int missingMultiple(int[] nums, int k) { 
        HashSet<Integer> hs = new HashSet<>(); 
        for(int i = 0; i < nums.length; i++){ 
            hs.add(nums[i]); 
        } 

        int i = 1;
        while (true) { 
            int mul = i * k; 
            if(!hs.contains(mul)){ 
                return mul; 
            } 
            i++;
        } 
    } 
}
