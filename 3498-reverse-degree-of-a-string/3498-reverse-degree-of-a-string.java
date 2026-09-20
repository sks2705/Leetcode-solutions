class Solution {
    public int reverseDegree(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        int sum=0;
        int product=1;
        int j=26;
        for(char ch ='a';ch<='z';ch++){
            hm.put(ch,j);
            j--;
        }
        for(int i =0;i<s.length();i++){
            char ch=s.charAt(i);
            product=hm.get(ch)*(i+1);
            sum+=product;
        }
        return sum;
    }
}