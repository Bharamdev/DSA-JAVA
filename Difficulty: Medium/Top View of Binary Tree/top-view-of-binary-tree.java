/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {
    static class pair{
        Node node;
        int pos;
        pair(Node node, int pos){
            this.node = node;
            this.pos=pos;
        }
    }
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        // code here
        if(root==null) return null;
        Map<Integer,Integer> map = new TreeMap<>();
        Queue<pair> q =new LinkedList<>();
        q.offer(new pair(root,0));
        // Queue<Node> q = new LinkedList<>();
        // Queue<Integer> n = new LinkedList<>();
        // q.offer(root);
        // n.offer(0);
        while(!q.isEmpty()){
            Node curr=q.peek().node;
            int num = q.poll().pos;
            if(!map.containsKey(num)){
                map.put(num,curr.data);
            }
            if(curr.left!=null){
                q.offer(new pair(curr.left, num-1));
            }
            if(curr.right!=null){
                q.offer(new pair(curr.right, num+1));
            }
        }
        ArrayList<Integer> arr = new ArrayList<>(map.values());
        return arr;
    }
}