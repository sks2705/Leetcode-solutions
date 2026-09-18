/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int count=0;
    public int goodNodes(TreeNode root) {
        int maxSofar=Integer.MIN_VALUE;
        countNodes(root,maxSofar);
        return count;
    }
    private void countNodes(TreeNode root,int maxSofar){
        if(root==null) return;
        if(root.val>=maxSofar){
            count++;
        }
        maxSofar=Math.max(maxSofar,root.val);
        countNodes(root.left,maxSofar);
        countNodes(root.right,maxSofar);
    }
}