class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        int max= Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i =0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
            min=Math.min(min,nums[i]);
        }
        HashSet<Integer> hs = new HashSet<>();
        for(int num:nums){
            hs.add(num);
        }
        int i=min;
        while(i<max){   
             if(!hs.contains(i)){
                result.add(i);
            }
            i++;
        }
        return result;
        
    }
}