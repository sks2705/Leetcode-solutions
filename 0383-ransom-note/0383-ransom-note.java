class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<ransomNote.length();i++){
            char ch=ransomNote.charAt(i);
            if(hm.containsKey(ch)){
                int of=hm.get(ch);
                int nf=of+1;
                hm.put(ch,nf);
            }
            else{
                hm.put(ch,1);
            }
        }
        for(int i=0;i<magazine.length();i++){
            char ch=magazine.charAt(i);

          if(hm.containsKey(ch)){
            
             if(hm.get(ch)==1){
                 hm.remove(ch);
              }
             else{
                int of=hm.get(ch);
                int nf=of-1;
                hm.put(ch,nf);
              }
            }
        }
        return hm.isEmpty();
    }
}