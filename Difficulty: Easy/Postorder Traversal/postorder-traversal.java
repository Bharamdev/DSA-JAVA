/*
class Node {
    int data;
    Node left, right;
    Node(int val){
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> arr = new ArrayList<>();
    public ArrayList<Integer> postOrder(Node root) {
        // code here
        if(root==null) return arr;
        postOrder(root.left);
        postOrder(root.right);
        arr.add(root.data);
        return arr;
    }
}