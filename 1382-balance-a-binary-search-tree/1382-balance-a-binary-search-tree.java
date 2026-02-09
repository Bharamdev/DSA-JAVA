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
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();

        inorder(root, list); //phle sort krege

        return builtbst(0, list.size()-1, list); //then binary search apply krege
    }
    public void inorder(TreeNode root, ArrayList<Integer> list){
        if(root==null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
    public TreeNode builtbst(int l, int r, ArrayList<Integer> list){
        if(l > r) return null;

        int mid = l + (r-l)/2;
        TreeNode root = new TreeNode(list.get(mid));

        root.left = builtbst(l, mid-1, list);
        root.right = builtbst(mid+1, r, list);

        return root;
    }
}