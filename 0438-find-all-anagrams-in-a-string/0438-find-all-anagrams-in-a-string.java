class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> list = new ArrayList<>();
        if(p.length()>s.length()){
            return list;
        }
        int [] need = new int[26];
        int [] window=new int[26];
        for(int i =0;i<p.length();i++){
            need[p.charAt(i)-'a']++;
            window[s.charAt(i)-'a']++;
        }
        if(Arrays.equals(need,window)){
            list.add(0);
            
        }
        for(int i=p.length();i<s.length();i++){
            window[s.charAt(i)-'a']++;
            window[s.charAt(i-p.length())-'a']--;
            if(Arrays.equals(window,need)){
                list.add(i-p.length()+1);
            }
        }
        return list;
        
    }
}