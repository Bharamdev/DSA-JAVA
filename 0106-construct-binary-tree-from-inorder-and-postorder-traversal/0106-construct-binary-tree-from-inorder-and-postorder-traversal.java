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
    int index;
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = postorder.length-1;
        for(int i=0;i<inorder.length;i++) map.put(inorder[i],i);
        return helper(postorder, 0, postorder.length-1);
    }
    TreeNode helper(int[] postorder, int start, int end){
        if(start>end) return null;
        int val = postorder[index--];
        TreeNode root = new TreeNode(val);
        int inIndex = map.get(val);
        root.right = helper(postorder, inIndex+1, end);
        root.left = helper(postorder, start, inIndex-1);
        return root; 
    }
}