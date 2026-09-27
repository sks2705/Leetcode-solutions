class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        
        if (goal < 0) {
            return 0;
        }
        int left = 0;
        int sum = 0;
        int count = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum > goal && left<=right) {
                sum -= nums[left];
                left++;
            }
            int pointer=left;
            int sum2=sum;
            while(sum2==goal && pointer <=right){
                sum2-=nums[pointer];
                pointer++;
                count++;
            }
        }
        return count;
    }
}