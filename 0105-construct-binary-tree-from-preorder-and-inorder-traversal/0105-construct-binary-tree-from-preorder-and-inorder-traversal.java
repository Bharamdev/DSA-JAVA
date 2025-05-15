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
    public int index=0;
    public Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(preorder,0,preorder.length-1);
    }
    public TreeNode helper(int[] preorder,int start,int end){
        if(start>end) return null;
        int rootval = preorder[index++];
        TreeNode root = new TreeNode(rootval);
        int inIndex = map.get(rootval);
        root.left = helper(preorder,start,inIndex-1);
        root.right = helper(preorder,inIndex+1,end);
        return root;
    }
}