class Solution {
    public int maxProfit(int[] prices) {
        int hold=-prices[0];
        int sold=0;
        int rest=0;
        for(int i =1;i<prices.length;i++){
            int newHold=Math.max(hold,rest-prices[i]);
            int newSold=hold+prices[i];
            int newRest=Math.max(rest,sold);
            
            hold=newHold;
            sold=newSold;
            rest=newRest;
        }
        return Math.max(sold,rest);
    }
}