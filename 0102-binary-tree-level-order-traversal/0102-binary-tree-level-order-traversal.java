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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result= new ArrayList<>();
        Queue<TreeNode> q= new LinkedList<>();
        if(root==null) return result;
        q.offer(root);
        while(!q.isEmpty()){
            int levelSize= q.size();
            List<Integer>currentList=new ArrayList<>();
            for(int i =0;i<levelSize;i++){
                TreeNode current = q.poll();
                currentList.add(current.val);
                if(current.left!=null){
                    q.offer(current.left);
                }
                if(current.right!=null){
                    q.offer(current.right);
                }
            }
            result.add(currentList);
        }
        return result;
    }
}