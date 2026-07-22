class Solution{
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hm = new HashMap<>();
        for(String s: strs){
            char [] c = s.toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            hm.putIfAbsent(key,new ArrayList<>());
            hm.get(key).add(s);
        }
        return new ArrayList<>(hm.values());
    }
}