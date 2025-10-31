/*
class Node {
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
    int cnt=0;
    int ans=-1;
    public int kthSmallest(Node root, int k) {
        // code here
        fn(root,k);
        return ans;
    }
    void fn(Node root, int k){
        if(root==null) return;
        fn(root.left,k);
        cnt++;
        if(cnt==k){
            ans=root.data;
            return;
        }
        fn(root.right,k);
    }
}