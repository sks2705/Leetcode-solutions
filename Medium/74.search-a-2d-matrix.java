/*
 You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

 Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
 */

 //https://leetcode.com/problems/search-a-2d-matrix

 class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Handle empty matrix case
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int r = 0;
        int c = matrix[0].length - 1; 

        while (r < matrix.length && c >= 0) {
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] < target) {
                r++; 
            } else {
                c--; 
            }
        }

        return false;
    }
}
