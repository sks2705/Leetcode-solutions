class Solution {
    public boolean isIsomorphic(String s, String t) {
    if(s.length()!=t.length()){
        return false;
    }
    int[] hash1=new int[256];
    int[] hash2=new int[256];
    for(int i =0;i<s.length();i++){
        int c1=s.charAt(i);
        int c2=t.charAt(i);
        if(hash1[c1]!=hash2[c2]){
            return false;
        }
        hash1[c1]=i+1;
        hash2[c2]=i+1;
    }
    return true;

    }
}
