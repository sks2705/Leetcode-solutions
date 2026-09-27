class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int num:nums){
            hm.put(num,hm.getOrDefault(num,0)+1);
        }
        int n=nums.length;
        for(int num:hm.keySet()){
            if(hm.get(num)>n/3){
                list.add(num);
            }
        }
        return list;
    }
}