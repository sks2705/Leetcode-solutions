class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length-1;
        int left=0;
        int right=nums.length-1;
        int [] result = new int[nums.length];
        while(left<=right){
            int rightsq=nums[right]*nums[right];
            int leftsq=nums[left]*nums[left];
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