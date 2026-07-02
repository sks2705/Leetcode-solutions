class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int width=0;
        int area= Integer.MIN_VALUE;
        while(left<right){
            width=right-left;
            int h=Math.min(height[left],height[right]);
            area=Math.max(area,width*h);
            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return area;
    }
}
