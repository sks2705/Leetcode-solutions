class Solution {
    public int[] sortedSquares(int[] nums) {
        int[]result=new int[nums.length];
        int n=nums.length-1;
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int leftsq=nums[left]*nums[left];
            int rightsq=nums[right]*nums[right];
            if(leftsq>rightsq){
                result[n]=leftsq;
                left++;
            }
            else{
                result[n]=rightsq;
                right--;
            }
            n--;
        }
        return result;

    }
}