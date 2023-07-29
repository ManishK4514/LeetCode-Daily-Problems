//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	    	
                Tree g = new Tree();
                float answer = g.findMedian(root);
                if(answer-(int)answer == 0)
        		    System.out.println((int)answer);
        		else
        		    System.out.println(answer);
                t--;
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Tree
{
    static int count = -1;
    static float left = 0;
    public static int countNode(Node root){
        if(root == null) return 0;
        return 1 + countNode(root.left) + countNode(root.right);
    }
    public static float calcMedian(int n, Node root){
        if(root == null) return 0;
        float l = calcMedian(n, root.left);
        
        count++;
        if(n % 2 != 0 && count == n/2) {
            // System.out.println("Hello: " + root.data);
            return root.data;
        }
        else if(n % 2 == 0 && count == n/2 - 1) left = root.data;
        else if(n % 2 == 0 && count == n/2) {
            // System.out.println(root.data + " " + left);
            return (float)(root.data + left)/2;
        }
        
        float r = calcMedian(n, root.right);
        
        return Math.max(l, r);
    }
    public static float findMedian(Node root)
    {
        int n = countNode(root);
        count = -1;
        left = 0;
        return calcMedian(n, root);
    }
}