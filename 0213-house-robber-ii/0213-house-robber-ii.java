class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        int[] first = Arrays.copyOfRange(nums,0,n-1);
        int[] second = Arrays.copyOfRange(nums,1,n);
        int []dp1=new int[first.length];
        int []dp2= new int[second.length];

        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);

        int case1=f(first,dp1,first.length-1);
        int case2=f(second,dp2,second.length-1);

        return Math.max(case1,case2);
    }

    private int f(int [] nums,int [] dp, int n){
        if(n<0) return 0;
        if(dp[n]!=-1) return dp[n];
        int pick=nums[n]+f(nums,dp,n-2);
        int notPick=f(nums,dp,n-1);

        return dp[n]=Math.max(pick,notPick);
    }
}