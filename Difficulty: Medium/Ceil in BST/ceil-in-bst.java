/* class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
} */

class Solution {
    int findCeil(Node root, int x) {
        // code here
        if(root==null) return -1;
        if(root.data==x) return root.data;
        if(x>root.data) return findCeil(root.right, x);
        int ceil = findCeil(root.left, x);
        return (ceil>=x && ceil!=-1) ? ceil : root.data; 
    }
}