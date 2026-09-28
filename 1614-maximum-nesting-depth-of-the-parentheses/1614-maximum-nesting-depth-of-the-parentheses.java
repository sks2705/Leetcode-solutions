class Solution {
    public int maxDepth(String s) {
    int i=0;
        int result =0;
        for(int j=0;j<s.length();j++){
            if(s.charAt(j)=='('){
                i++;
            }
            else if(s.charAt(j)==')'){
                i--;
            }
            result =Math.max(i,result);
        }
        return result;
        
    }
}