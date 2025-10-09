/*
class Node {
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    ArrayList<Integer> zigZagTraversal(Node root) {
        // code here
        Deque<Node> dq = new LinkedList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        dq.offerFirst(root);
        boolean reverse = false;
        while(!dq.isEmpty()){
            int size = dq.size();
            for(int i=0;i<size;i++){
                if(!reverse){
                    Node curr = dq.pollFirst();
                    arr.add(curr.data);
                    if(curr.left!=null) dq.offerLast(curr.left);
                    if(curr.right!=null) dq.offerLast(curr.right);
                }
                else{
                    Node curr = dq.pollLast();
                    arr.add(curr.data);
                    if(curr.right!=null) dq.offerFirst(curr.right);
                    if(curr.left!=null) dq.offerFirst(curr.left);
                }
            }
            reverse = !reverse;
        }
        return arr;
    }
}