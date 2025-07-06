/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    Node LCA(Node root, Node n1, Node n2) {
        // your code here.
        if(root==null || root==n1 || root==n2) return root;
        Node left = LCA(root.left,n1,n2);
        Node right = LCA(root.right,n1,n2);
        if(left!=null & right!=null) return root;
        return right==null ? left : right;
    }
    
}