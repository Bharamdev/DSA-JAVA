/*
class Node
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references

    // Constructor of tree node
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> bottomView(Node root) {
        // Code here
        // ArrayList<Integer> arr = new ArrayList<>();
        Queue<Node> q = new LinkedList<>(); 
        Queue<Integer> hd = new LinkedList<>();
        Map<Integer,Integer> map = new TreeMap<>();
        q.offer(root);
        hd.offer(0);
        while(!q.isEmpty()){
            Node curr = q.poll();
            int num = hd.poll();
            map.put(num,curr.data);
            if(curr.left!=null){
                q.offer(curr.left);
                hd.offer(num-1);
            }
            if(curr.right!=null){
                q.offer(curr.right);
                hd.offer(num+1);
            }
        }
        ArrayList<Integer> arr = new ArrayList<>(map.values());
        return arr;
    }
}