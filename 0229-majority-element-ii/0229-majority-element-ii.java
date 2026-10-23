class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        ArrayList<Integer>list=new  ArrayList<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i: nums){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        for(int i: hm.keySet()){
            if(hm.get(i)>(n/3)){
                list.add(i);
            }
        }
        return list;
    }
}