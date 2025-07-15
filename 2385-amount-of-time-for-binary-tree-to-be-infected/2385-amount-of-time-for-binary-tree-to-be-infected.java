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
    public int amountOfTime(TreeNode root, int start) {
        TreeNode st = startNode(root,start);
        if(root==null || st==null) return 0;
        Map<TreeNode,TreeNode> parent = new HashMap<>();
        buildParent(root,parent);
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(st);
        Map<TreeNode,Boolean> visited = new HashMap<>();
        visited.put(st,true);
        int cnt=0;
        while(!q.isEmpty()){
            int size=q.size();
            cnt++;
            for(int i=0;i<size;i++){
                TreeNode curr= q.poll();
                if(curr.left!=null && visited.get(curr.left)==null){
                    visited.put(curr.left,true);
                    q.offer(curr.left);
                }
                if(curr.right!=null && visited.get(curr.right)==null){
                    visited.put(curr.right,true);
                    q.offer(curr.right);
                }
                if(parent.get(curr)!=null && visited.get(parent.get(curr))==null){
                    visited.put(parent.get(curr),true);
                    q.offer(parent.get(curr));
                }
            }
        }
        return cnt-1;
    }
    public TreeNode startNode(TreeNode root, int start){
        if(root==null || root.val==start) return root;
        TreeNode left = startNode(root.left,start);
        if(left!=null) return left;
        return startNode(root.right,start);
    }
    public void buildParent(TreeNode root, Map<TreeNode,TreeNode> parent){
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(curr.left!=null){
                    parent.put(curr.left,curr);
                    q.offer(curr.left);
                }
                if(curr.right!=null){
                    parent.put(curr.right,curr);
                    q.offer(curr.right);
                }
            }
        }
    }
}