//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.io.*;

public class Main
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int m = Integer.parseInt(inputLine[1]);
		    long arr1[] = new long[n];
		    long arr2[] = new long[m];
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr1[i] = Long.parseLong(inputLine[i]);
		    }
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<m; i++){
		        arr2[i] = Long.parseLong(inputLine[i]);
		    }
		    Solution ob = new Solution();
		    ob.merge(arr1, arr2, n, m);
		    
		    StringBuffer str = new StringBuffer();
		    for(int i=0; i<n; i++){
		        str.append(arr1[i]+" ");
		    }
		    for(int i=0; i<m; i++){
		        str.append(arr2[i]+" ");
		    }
		    System.out.println(str);
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to merge the arrays.
    
    public static void swapIfGreater(long arr1[], long arr2[], int left, int right){
        if(arr1[left] > arr2[right]){
            long temp = arr1[left];
            arr1[left] = arr2[right];
            arr2[right] = temp;
        }
    }
    public static void merge(long arr1[], long arr2[], int n, int m) 
    {
        int len = (n + m);
        int gap = (len/2) + (len % 2);
        while(gap > 0){
            int left = 0;
            int right = left + gap;
            
            while(right < len){
                // left in arr1 and right in arr2
                if(left < n && right >= n){
                    swapIfGreater(arr1, arr2, left, right - n);
                }
                // left in arr2 and right in arr2
                else if(left >= n){
                    swapIfGreater(arr2, arr2, left - n, right - n);
                }
                // left in arr1 and right in arr1
                else{
                    swapIfGreater(arr1, arr1, left, right);
                }
                left++; right++;
            }
            if(gap == 1) break;
            gap = (gap/2) + (gap % 2);
        }
    }
}
