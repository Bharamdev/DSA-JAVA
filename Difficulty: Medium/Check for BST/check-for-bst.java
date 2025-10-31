/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public boolean isBST(Node root) {
        // code here
        return fn(root,null,null);
    }
    boolean fn(Node root, Integer low, Integer high){
        if(root==null) return true;
        if(low!=null && low>root.data) return false;
        if(high!=null && high<root.data) return false;
        boolean left = fn(root.left, low, root.data);
        boolean right = fn(root.right, root.data, high);
        return left && right;
    }
}