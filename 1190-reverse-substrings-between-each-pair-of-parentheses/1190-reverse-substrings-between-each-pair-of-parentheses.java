class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        StringBuilder ans= new StringBuilder();
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push(ans.length());
            }
            else if(s.charAt(i)==')'){
                int j=st.pop();
                int k=ans.length()-1;
                while(j<k){
                    char temp=ans.charAt(j);
                    ans.setCharAt(j,ans.charAt(k));
                    ans.setCharAt(k,temp);
                    j++;
                    k--;
                }
            }
            else{
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
}