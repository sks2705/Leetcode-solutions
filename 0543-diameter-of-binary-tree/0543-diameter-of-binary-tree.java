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
    public int diameterOfBinaryTree(TreeNode root) {
        int [] diameter = new int[1];
        height(root,diameter);
        return diameter[0];
    }
    private int height(TreeNode t1, int[] diameter){
        if(t1==null) return 0 ;
        int lh=height(t1.left,diameter);
        int rh=height(t1.right,diameter);
        int max = Math.max(lh,rh);
        diameter[0]=Math.max(rh+lh,diameter[0]);
        return Math.max(rh,lh)+1;
    }
}