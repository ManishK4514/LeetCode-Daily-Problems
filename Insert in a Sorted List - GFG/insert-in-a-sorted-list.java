//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
    
}
class GFG{
	static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
	
    public static void main(String args[]) throws IOException { 
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t > 0){
            int n = sc.nextInt();
            
            Node head = new Node(sc.nextInt());
            Node tail = head;
            
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            
            int k = sc.nextInt();
            
            Solution g = new Solution();
            head = g.sortedInsert(head,k);
            
            printList(head); 
            t--;
        }
    } 
} 

// } Driver Code Ends


/*class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }*/

// sortedInsert method should return the head of the modified linked list.
class Solution {
    Node sortedInsert(Node head1, int key) {
        Node newNode = new Node(key);
        Node node = head1;
        
        // insert at first node
        if(node.data >= key) {
            newNode.next = head1; 
            return newNode;
        }
        
        Node prev = null;
        int p = Integer.MIN_VALUE;
        
        boolean inserted = false;
        
        while(node != null) {
            
            // insert at mid
            if(key >= p && key < node.data) {
                prev.next = newNode;
                newNode.next = node;
                inserted = true;
            }
            
            prev = node;
            p = prev.data;
            node = node.next;
        }
        
        // insert at last node
        if(!inserted) prev.next = newNode;
        
        return head1;
    }
}