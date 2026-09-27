class Solution {
    public int[] findErrorNums(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        int duplicate=-1;
        int missing=-1;
        for(int i =1;i<=nums.length;i++){
            if(!hm.containsKey(i)){
                missing=i;
            }
            else if(hm.get(i)>1){
              duplicate=i;   
            }
        }

        return new int[]{duplicate,missing};

    }
}