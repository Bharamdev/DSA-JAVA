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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> q = new LinkedList<>();
        q.offerFirst(root);
        if(root==null) return ans;
        boolean reverse = false;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0;i<size;i++){
                if(!reverse){
                    TreeNode current = q.pollFirst();
                    level.add(current.val);
                    if(current.left!=null){
                        q.offerLast(current.left);
                    }
                    if(current.right!=null){
                        q.offerLast(current.right);
                    }
                }
                else{
                    TreeNode current = q.pollLast();
                    level.add(current.val);
                    if(current.right!=null){
                        q.offerFirst(current.right);
                    }
                    if(current.left!=null){
                        q.offerFirst(current.left);
                    }
                }
            }
            reverse = !reverse;
            ans.add(level);
        }
        return ans;
    }
}