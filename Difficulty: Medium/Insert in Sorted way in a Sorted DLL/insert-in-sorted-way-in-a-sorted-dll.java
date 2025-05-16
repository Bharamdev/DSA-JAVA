//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Ignore the newline character after t

        while (t-- > 0) {
            String input = sc.nextLine(); // Read the entire line for the array elements
            String[] values = input.split(" ");

            Node head = null, tail = null;
            for (String value : values) {
                int x = Integer.parseInt(value);
                if (head == null) {
                    head = new Node(x);
                    tail = head;
                } else {
                    tail.next = new Node(x);
                    tail.next.prev = tail;
                    tail = tail.next;
                }
            }

            int valueToInsert = sc.nextInt();
            if (sc.hasNextLine()) {
                sc.nextLine(); // Ignore the newline character after the value
            }

            Solution obj = new Solution();
            head = obj.sortedInsert(head, valueToInsert);
            if (!validate(head))
                System.out.println("Invalid DLL");
            else
                printList(head);

            System.out.println("~");
        }

        sc.close();
    }

    public static boolean validate(Node head) {
        Node current = head;
        while (current.next != null) {
            if (current.next.prev != current) {
                return false;
            }
            current = current.next;
        }
        return true;
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

// } Driver Code Ends


/*class of the node of the DLL is as
/*
class Node {
    int data;
    Node prev, next;
    Node(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}
*/
class Solution {
    public Node sortedInsert(Node head, int x) {
        // add your code here
        Node newNode = new Node(x);
        if(head == null) return newNode;
        Node temp = head;
        if(x<=head.data){
            newNode.next = head;
            head.prev = newNode;
            return newNode;
        }
        while(temp!=null && temp.next!=null){
            if(temp.next.data>=x){
                newNode.next = temp.next;
                temp.next.prev = newNode;
                temp.next=newNode;
                newNode.prev = temp;
                return head;
            }
             temp = temp.next;
        }
        if(temp.next==null){
            temp.next=newNode;
            newNode.prev=temp;
        }
        return head;
    }
}