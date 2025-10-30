/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    static ArrayList<ArrayList<Integer>> ans;
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        ans = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        fn(root,path);
        return ans;
    }
    static void fn(Node root, ArrayList<Integer> path){
        path.add(root.data);
        if(root.left==null && root.right==null){
            ans.add(new ArrayList<>(path));
        }
        if(root.left!=null) fn(root.left,path);
        if(root.right!=null) fn(root.right,path);
        path.remove(path.size()-1);
    }
}