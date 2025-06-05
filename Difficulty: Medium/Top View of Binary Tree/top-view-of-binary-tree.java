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
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        // code here
        if(root==null) return null;
        Map<Integer,Integer> map = new TreeMap<>();
        Queue<Node> q = new LinkedList<>();
        Queue<Integer> n = new LinkedList<>();
        q.offer(root);
        n.offer(0);
        while(!q.isEmpty()){
            Node curr=q.poll();
            int num = n.poll();
            if(!map.containsKey(num)){
                map.put(num,curr.data);
            }
            if(curr.left!=null){
                q.offer(curr.left);
                n.offer(num-1);
            }
            if(curr.right!=null){
                q.offer(curr.right);
                n.offer(num+1);
            }
        }
        ArrayList<Integer> arr = new ArrayList<>(map.values());
        return arr;
    }
}