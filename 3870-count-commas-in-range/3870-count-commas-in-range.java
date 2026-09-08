class Solution {
    public int countCommas(int n) {
        if(n>1 && n<=999){
            return 0;
        }
        int digitCount=0;
        for(int i=1000;i<=n;i++){
            digitCount++;
        }
        return digitCount;
    }
}