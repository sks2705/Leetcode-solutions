class Solution {
    public boolean checkDivisibility(int n) {
        int originalNum=n;
        int digiPro=1;
        int digiSum=0;
        while(n>0){
            int rem=n%10;
            digiPro*=rem;
            digiSum+=rem;
            n/=10;
        }
        int sum=digiSum+digiPro;
        if(sum==0) return false;
        if( originalNum%sum ==0){
            return true;
        }
        return false;
    }
}