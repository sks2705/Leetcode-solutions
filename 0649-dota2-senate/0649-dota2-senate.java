class Solution {
    public String predictPartyVictory(String senate) {
        int n=senate.length();
        Queue<Integer> rad= new LinkedList<>();
        Queue<Integer> dir= new LinkedList<>();
        for(int i =0;i<senate.length();i++){
            if(senate.charAt(i)=='R'){
                rad.offer(i);
            }
            else{
                dir.offer(i);
            }
        }
        while(!rad.isEmpty() && !dir.isEmpty()){
            int rIndex=rad.poll();
            int dIndex=dir.poll();
            if(rIndex<dIndex){
                rad.offer(rIndex+n);
            }else{
                dir.offer(dIndex+n);
            }
        }
        return rad.isEmpty()? "Dire":"Radiant";
        
    }
}