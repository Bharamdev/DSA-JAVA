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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> str = new ArrayList<>();
        helper(root,str);
        return String.join(",",str);
    }
    public void helper(TreeNode root, List<String> str){
        if(root==null){
            str.add("null");
            return;
        }
        str.add(String.valueOf(root.val));
        helper(root.left,str);
        helper(root.right,str);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        List<String> str2 = new ArrayList<>(Arrays.asList(arr));
        TreeNode node = helper2(str2);
        return node;
    }
    public TreeNode helper2(List<String> str){
        String val = str.remove(0);
        if(val.equals("null")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = helper2(str);
        node.right = helper2(str);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));