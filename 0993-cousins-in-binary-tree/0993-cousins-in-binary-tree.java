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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null) return false;
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            boolean xCheck = false;
            boolean yCheck = false;   
            for(int i=0;i<size;i++){
                TreeNode current = q.poll();
                if(current.left!=null && current.right!=null){
                    if((current.left.val == x && current.right.val == y) || 
                    (current.left.val == y && current.right.val == x) ) return false;
                }
                if(current.val == x ) xCheck = true;
                if(current.val == y ) yCheck = true;
                if(current.left!=null) q.offer(current.left);
                if(current.right!=null) q.offer(current.right);
            }
            if(xCheck && yCheck) return true;
            if(xCheck || yCheck) return false;
        }
        return false;
    }
}