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
    class pair{
        int depth;
        TreeNode node;
        pair(int depth, TreeNode node){
            this.depth = depth;
            this.node = node;
        } 
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }
    pair dfs(TreeNode root){
        if(root==null) return new pair(0, root);
        pair left = dfs(root.left);
        pair right = dfs(root.right);
        if(left.depth==right.depth) return new pair(left.depth+1, root);
        if(left.depth>right.depth) return  new pair(left.depth+1, left.node);
        return new pair(right.depth+1, right.node);
    }
}