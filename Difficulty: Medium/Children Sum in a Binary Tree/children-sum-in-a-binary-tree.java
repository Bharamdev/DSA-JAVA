/*Complete the function below
Node is as follows:
class Node{
    int data;
    Node left,right;

    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

*/
class Solution {
    // Function to check whether all nodes of a tree have the value
    // equal to the sum of their child nodes.
    public static int isSumProperty(Node root) {
        // add your code here
        if(root==null || (root.right==null && root.left==null)) return 1;
        int child=0;
        if(root.right!=null) child+=root.right.data;
        if(root.left!=null) child+=root.left.data;
        if(child!=root.data) return 0;
       
        int left=isSumProperty(root.left);
        int right=isSumProperty(root.right);
        return (left==1 && right==1) ? 1 : 0;
        
    }
}