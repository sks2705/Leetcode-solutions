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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer>result= new ArrayList<>();
        if(root!=null) {
            treeView(root,0,result);
        }
        return result;
    }
    private void treeView(TreeNode root,int depth,List<Integer> result){
        if(root==null){
            return;
        }
        if(result.size()==depth){
            result.add(root.val);
        }
        treeView(root.right,depth+1,result);
        treeView(root.left,depth+1,result);
    } 
}