// User function Template for Java

/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
} */

class Solution {
    public static ArrayList<Integer> printCousins(Node root, Node node_to_find) {
        // code here
        Node key = node_to_find;
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null){
            ans.add(-1);
            return ans;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        boolean found=false;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Node curr = q.poll();
                if((curr.left!=null && curr.left==key) ||
                   (curr.right!=null && curr.right==key)){
                    found=true;  
                    continue;
                }
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
            }
            if(found){
                if(q.isEmpty()){
                   ans.add(-1);
                   return ans;
                }
                else{
                    while(!q.isEmpty()) ans.add(q.poll().data);
                }
                break;
            }
        }
        if (!found && ans.isEmpty()) ans.add(-1);
        return ans;
    }
}