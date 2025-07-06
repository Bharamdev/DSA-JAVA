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
 class pair{
    TreeNode node;
    int num;
    pair(TreeNode node, int num){
        this.node = node;
        this.num = num;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int ans=0;
        Queue<pair> q = new LinkedList<>();
        q.offer(new pair(root,0));
        while(!q.isEmpty()){
            int size= q.size();
            int min = q.peek().num;
            int r=0,l=0;
            for(int i=0;i<size;i++){
                TreeNode node = q.peek().node;
                int curr_id = q.peek().num-min;
                q.poll();
                if(i==0) l= curr_id;
                if(i==size-1)  r=curr_id;
                if(node.left!=null) q.offer(new pair(node.left,2*curr_id+1));
                if(node.right!=null) q.offer(new pair(node.right,2*curr_id+2)); 
            }
            ans = Math.max(ans,r-l+1);
        }
        return ans;
    }
}