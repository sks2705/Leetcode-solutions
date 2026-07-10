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

    public static int height(TreeNode root,int[] diameter){
        if(root==null) return 0;
        int lh=height(root.left,diameter);
        int rh =height(root.right,diameter);
        diameter[0]=Math.max(rh+lh,diameter[0]);
        return Math.max(rh,lh)+1;

    }
}