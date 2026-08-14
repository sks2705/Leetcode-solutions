class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        int left=0;
        int max=Integer.MIN_VALUE;   
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            while(hm.get(ch)>2){
                char c=s.charAt(left);
                hm.put(c,hm.get(c)-1);
                left++; 
            }
            
            max=Math.max(i-left+1,max);  
        }
        return max;
        
    }
}