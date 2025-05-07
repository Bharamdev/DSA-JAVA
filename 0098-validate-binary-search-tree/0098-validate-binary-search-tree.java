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
    public boolean isValidBST(TreeNode root) {
        return VBT(root,null,null);
    }
    public boolean VBT(TreeNode node, Integer low, Integer high){
        if(node==null) return true;
        if(low!=null && node.val<=low) return false;
        if(high!=null && node.val>=high) return false;
        boolean left = VBT(node.left,low,node.val);
        boolean right = VBT(node.right,node.val,high);
        return left && right;
    }
}