/*
node class of the binary tree
class Node
{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}
*/
class Tree {
    // Function to check whether a binary tree is foldable or not.
    boolean IsFoldable(Node node) {
        // your code
        if(node==null) return true;
        return helper(node.left, node.right);
    }
    boolean helper(Node a, Node b){
        if(a==null && b==null) return true;
        if(a==null || b==null) return false;
        return helper(a.left, b.right) && helper(a.right, b.left);
    }
}