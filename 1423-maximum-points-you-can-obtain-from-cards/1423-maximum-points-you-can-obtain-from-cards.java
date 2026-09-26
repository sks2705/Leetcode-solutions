class Solution {

    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int leftSum=0;
        int rightSum=0;
        int max=Integer.MIN_VALUE;
        for(int i =0;i<k;i++){
            leftSum+=cardPoints[i];
        }
       max=leftSum;
        for(int i =0;i<k;i++){
            leftSum-=cardPoints[k-1-i];
            rightSum+=cardPoints[n-1-i];
            max=Math.max(rightSum+leftSum,max);
        }
        return max;
    }
}