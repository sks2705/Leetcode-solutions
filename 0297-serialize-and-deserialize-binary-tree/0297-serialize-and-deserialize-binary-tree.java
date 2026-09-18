/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();

        serializeHelper(root, sb);

        return sb.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder sb) {

        if (root == null) {
            sb.append("null,");
            return;
        }

        sb.append(root.val).append(",");

        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }


    public TreeNode deserialize(String data) {

        String[] values = data.split(",");

        int[] index = {0};

        return deserializeHelper(values, index);
    }

    private TreeNode deserializeHelper(String[] values, int[] index) {

        if (values[index[0]].equals("null")) {
            index[0]++;
            return null;
        }

        TreeNode root =
            new TreeNode(Integer.parseInt(values[index[0]]));

        index[0]++;

        root.left = deserializeHelper(values, index);

        root.right = deserializeHelper(values, index);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));