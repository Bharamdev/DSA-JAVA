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
    public int goodNodes(TreeNode root) {
        return CGN(root,root.val);
    }
    public int CGN(TreeNode root, int maxVal){
        if(root==null) return 0;
        int good=0;
        if(root.val>=maxVal) good=1;
        maxVal = Math.max(maxVal,root.val);
        good+=CGN(root.left,maxVal);
        good+=CGN(root.right,maxVal);
        return good;
    }
}