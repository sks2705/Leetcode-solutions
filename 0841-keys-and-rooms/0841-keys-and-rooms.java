class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean[] vis= new boolean[n];
        Queue<Integer>  q = new LinkedList<>();
        q.offer(0);
        vis[0]=true;
        int count=1;
        while(!q.isEmpty()){
            int room=q.poll();
            for(int key:rooms.get(room)){
                if(!vis[key]){
                    vis[key]=true;
                    count++;
                    q.offer(key);
                }
            }
        }
        return count==n;
        
    }
}