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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer>list1=new ArrayList<>();
        ArrayList<Integer>list2=new ArrayList<>();

        leafValue(root1,list1);
        leafValue(root2,list2);

        return list1.equals(list2);
    }
    private void leafValue(TreeNode root,List<Integer>list){
        if(root==null){
            return;
        }
        if(root.left == null && root.right==null){
            list.add(root.val);
            return;
        }
        leafValue(root.left, list);
        leafValue(root.right,list); 
    }
}