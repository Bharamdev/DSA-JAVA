/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parent = new HashMap<>();
        buildParent(root,parent);
        Queue<TreeNode> q= new LinkedList<>();
        Map<TreeNode,Boolean> visited = new HashMap<>();
        q.offer(target);
        visited.put(target,true);
        int cnt=0;
        while(!q.isEmpty()){
            int size = q.size();
            if(cnt==k) break;
            cnt++;
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(curr.left!=null && visited.get(curr.left)==null ){
                    q.offer(curr.left);
                    visited.put(curr.left,true);
                }
                if(curr.right!=null && visited.get(curr.right)==null){
                    q.offer(curr.right);
                    visited.put(curr.right,true);
                }
                if(parent.get(curr)!=null && visited.get(parent.get(curr))==null ){
                    q.offer(parent.get(curr));
                    visited.put(parent.get(curr),true);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for(TreeNode n: q) res.add(n.val);
        return res;

    }
    public void buildParent(TreeNode root, Map<TreeNode,TreeNode> parent){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(curr.left!=null) {
                    parent.put(curr.left,curr);
                    q.offer(curr.left);
                }
                if(curr.right!=null) {
                    parent.put(curr.right,curr);
                    q.offer(curr.right);
                }
            }
        }
    }
}