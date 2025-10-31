class GFG {
    // Function to construct the BST from its given level order traversal.
    public Node constructBST(int[] arr) {
        // Write your code here
        Node root = null;
        for(int num: arr){
            root = fn(root,num);
        }
        return root;
    }
    Node fn(Node root, int num){
        if(root==null) root = new Node(num);
        if(num<root.data) root.left = fn(root.left, num);
        if(num>root.data) root.right = fn(root.right, num);
        return root;
    }
}