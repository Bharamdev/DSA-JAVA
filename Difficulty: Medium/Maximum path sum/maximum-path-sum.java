/*
class Node{
    int data;
    Node left, right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    int maxi = Integer.MIN_VALUE;
    int findMaxSum(Node root) {
        // code here
        helper(root);
        return maxi;
    }
    int helper(Node node){
        if(node==null) return 0;
        int left = Math.max(helper(node.left),0);
        int right = Math.max(helper(node.right),0);
        int sum= left+right+node.data;
        maxi = Math.max(maxi,sum);
        return node.data + Math.max(left,right);
    }
}