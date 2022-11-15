//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			Solution T = new Solution();
			ArrayList<Integer> arr= T.mergeKArrays(a, n);
			for(int i = 0; i < n*n ; i++)
			    System.out.print(arr.get(i)+" ");
		    System.out.println();
		    
		    t--;
		}
	}
}


// } Driver Code Ends


//User function Template for Java

class Pair implements Comparable<Pair>{
    int value;
    int row;
    int col;
    Pair(int value, int row, int col){
        this.value = value;
        this.row = row;
        this.col = col;
    }
    public int compareTo(Pair o){
        return this.value - o.value;
    }
}
class Solution
{
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int k) 
    {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            Pair pair = new Pair(arr[i][0], i, 0);
            pq.add(pair);
        }
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            list.add(curr.value);
            int row = curr.row;
            if(curr.col + 1 < arr[row].length){
                Pair pair = new Pair(arr[row][curr.col + 1], row, curr.col + 1);
                pq.add(pair);
            }
        }
        return list;
    }
}