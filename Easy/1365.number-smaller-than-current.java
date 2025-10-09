/*
 Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].

Return the answer in an array.

 

Example 1:

Input: nums = [8,1,2,2,3]
Output: [4,0,1,1,3]
 */

 //https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number

 import java.util.*;

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.putIfAbsent(sorted[i], i);
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = map.get(nums[i]);
        }

        return res;
    }
}
