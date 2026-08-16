class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        int left=0;
        int max=0;
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            while(hm.get(ch)>1){
                char leftChar=s.charAt(left);
                hm.put(leftChar,hm.get(leftChar)-1);
                left++;
            }
            max=Math.max(i-left+1,max);
        }
        return max;

    }
}
