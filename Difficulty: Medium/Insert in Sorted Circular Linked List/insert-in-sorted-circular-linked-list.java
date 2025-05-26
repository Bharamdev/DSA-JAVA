

// User function Template for Java
class Solution {
    public Node sortedInsert(Node head, int data) {
        // code here
        Node newNode = new Node(data);
        if(head==null){
            newNode.next=newNode;
            return newNode;
        }
        Node temp = head;
        if(data<=head.data){
            while(temp.next!=head) temp=temp.next;
            temp.next=newNode;
            newNode.next=head;
            return newNode;
        }
        while(temp.next!=head && temp.next.data<data){
            temp=temp.next;
        }
        newNode.next=temp.next;
        temp.next=newNode;
        return head;
    }
}