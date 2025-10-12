/*
class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> ans;
    ArrayList<Integer> boundaryTraversal(Node root) {
        // code here
        ans = new ArrayList<>();
        if(root==null) return ans;
        if(!isLeaf(root)) ans.add(root.data);
        addLeft(root);    // left boundary
        addLeaf(root);    // leaf nodes
        addRight(root);       // right boundary
        return ans;
    }
    boolean isLeaf(Node root){
        return (root.right==null && root.left==null); 
    }
    void addLeft(Node node){
        Node curr = node.left;
        while(curr!=null){
            if(!isLeaf(curr)) ans.add(curr.data);
            if(curr.left!=null) curr = curr.left;
            else curr = curr.right;
        }
    }
    void addLeaf(Node node){
        if(node==null) return;
        if(isLeaf(node)){
            ans.add(node.data);
            return;
        }
        addLeaf(node.left);
        addLeaf(node.right);
    }
    void addRight(Node node){
        Node curr = node.right;
        ArrayList<Integer> temp = new ArrayList<>();
        while(curr!=null){
            if(!isLeaf(curr)) temp.add(curr.data);
            if(curr.right!=null) curr = curr.right;
            else curr = curr.left;
        }
        Collections.reverse(temp);
        ans.addAll(temp);
    }
}