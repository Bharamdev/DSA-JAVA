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
    long totalsum=0;
    int mod=(int)1e9+7;
    long maxProduct = 0;
    public int maxProduct(TreeNode root) {
        totalsum = getsum(root);
        subtreeSum(root);
        return (int)(maxProduct%mod);
    }
    long getsum(TreeNode root){
        if(root==null) return 0;
        long left = getsum(root.left);
        long right = getsum(root.right);
        return root.val + left + right;
    }
    long subtreeSum(TreeNode root){
        if(root==null) return 0;
        long left = subtreeSum(root.left);
        long right = subtreeSum(root.right);
        long curr = root.val + left + right;
        long product = curr * (totalsum-curr);
        maxProduct = Math.max(maxProduct, product);
        return curr;
    }
}