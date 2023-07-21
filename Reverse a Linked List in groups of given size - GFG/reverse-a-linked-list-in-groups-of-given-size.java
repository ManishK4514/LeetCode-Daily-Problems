//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class ReverseInSize
{
    static Node head;
    
    public static void main (String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int a1 = Integer.parseInt(s[0]);
            Node head = new Node(a1);
            Node tail = head;
            for(int i = 1; i < n; i++)
            {
                int a = Integer.parseInt(s[i]);
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail =tail.next;
            }
            
            int k = Integer.parseInt(in.readLine().trim());
            Solution ob = new Solution();
            Node res = ob.reverse(head, k);
            printList(res,out);
            out.println();
        }
        out.close();
    }
    
    public static void printList(Node node,PrintWriter out)
    {
        while(node != null)
        {
            out.print(node.data + " ");
            node = node.next;
        }
    }
    
}


// } Driver Code Ends


/*node class of the linked list

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution
{
    public static Node reverse(Node head){
        if(head == null || head.next == null) return head;
        Node node = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }  
    public static Node reverse(Node head, int k)
    {
        boolean first = true;
        Node newHead = head;
        Node preTail = null;
        int count = 0;
        Node node = head, tmpHead = head;
        while(node != null){
            count++;
            if(count % k == 0){
                Node prev = node;
                node = node.next;
                prev.next = null;
                Node curr = reverse(tmpHead);
                if(first){
                    newHead = curr;
                    first = !first;
                }
                if(preTail != null){                    
                    preTail.next = curr;
                }
                preTail = tmpHead;
                tmpHead = node;
            }
            else node = node.next;
        }
        
        if(count % k != 0) {
            Node curr = reverse(tmpHead);
            preTail.next = curr;
        }
        
        return newHead;
    }
}

