class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length==0) return 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<stones.length;i++){
            pq.add(stones[i]);
        }
        while(pq.size()>1){
            int a=pq.remove();
            if(a==pq.peek()){
                pq.remove();
            }
            else if(a!=pq.peek()){
                int diff=a-pq.peek();
                pq.remove();
                pq.add(diff);
            }
        }
        return pq.isEmpty()?0:pq.peek();

        
    }
}