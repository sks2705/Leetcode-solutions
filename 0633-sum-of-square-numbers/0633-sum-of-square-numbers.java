class Solution {
    public boolean judgeSquareSum(int c) {
        long left=0;
        long right=(long)Math.sqrt(c);
        while(left<=right){
            long sq=(left*left)+(right*right);
            if(sq==c){
                return true;
            }
            if(sq<c){
                left++;
            }
            else{
                right--;
            }
        }
        return false;
    }
}