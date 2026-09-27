class Solution {
    public String frequencySort(String s) {
        
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>(
            (a,b)->hm.get(b)-hm.get(a)
        );
        StringBuilder sb = new StringBuilder();
        pq.addAll(hm.keySet());
        while(!pq.isEmpty()){
            char ch =pq.poll();
            for(int i =0;i<hm.get(ch);i++){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}