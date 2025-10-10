/*
 Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.

For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 

Example 1:

Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.
 */

 //https://leetcode.com/problems/sqrtx/


 class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] freq = new int[101];

        for (int num : nums) freq[num]++;

       
        for (int i = 1; i <= 100; i++) {
            freq[i] += freq[i - 1];
        }

     
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i] == 0 ? 0 : freq[nums[i] - 1];
        }

        return res;
    }
}
