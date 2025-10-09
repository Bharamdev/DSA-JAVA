/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<size;i++){
                Node curr = q.poll();
                list.add(curr.val);
                List<Node> nodes = curr.children;
                int len = nodes.size();
                for(int j=0;j<len;j++){
                    q.offer(nodes.get(j));
                }
            }
            ans.add(list);
        }
        return ans;
    }
}