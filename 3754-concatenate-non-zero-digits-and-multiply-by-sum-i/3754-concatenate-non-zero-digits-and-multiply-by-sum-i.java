class Solution {
    public long sumAndMultiply(int n) {
        if(n==0){
            return 0;
        }
        String s=Integer.toString(n);
        String ans="";
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch!='0'){
                ans+=ch;
            }

        }
        int sum=0;
        for(int i =0;i<ans.length();i++){
            sum+=ans.charAt(i)-'0';
        }
        int num = Integer.parseInt(ans);

        return (long)sum*num;
        
    }
}