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
    public List<Integer> inorderTraversal(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();
        preorder(root,list);
        return list;
    }

    private void preorder(TreeNode root, List<Integer> result){
        if(root==null) return;
        preorder(root.left,result);
        result.add(root.val);
        preorder(root.right,result);
    }
}