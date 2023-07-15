//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.countWays(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Pair{
    long first;
    long second;
    Pair(long first, long second){
        this.first = first;
        this.second = second;
    }
}
class Solution{
    private static HashMap<String, Pair> cache;
    
    public static Pair helper(int i, int j, char[] arr){
        String key = i + "-" + j;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        
        if(i == j) {
            int t = arr[i] - '0';
            Pair result = (t == 0) ? new Pair(0, 1) : new Pair(1, 0);
            cache.put(key, result);
            return result;
        }
        
        long t = 0, f = 0;
        for(int k = i; k < j; k++){
            if(arr[k] == '&' || arr[k] == '|' || arr[k] == '^'){
                Pair left = helper(i, k - 1, arr);
                Pair right = helper(k + 1, j, arr);
                
                if(arr[k] == '&') {
                    t += left.first * right.first;
                    t %= 1003L;
                    f += left.first * right.second;
                    f %= 1003L;
                    f += left.second * (right.first + right.second);
                    f %= 1003L;
                } else if(arr[k] == '|') {
                    t += left.second * right.first;
                    t %= 1003L;
                    t += left.first * (right.first + right.second);
                    t %= 1003L;
                    f += left.second * right.second;
                    f %= 1003L;
                } else {
                    t += left.first * right.second;
                    t %= 1003L;
                    t += left.second * right.first;
                    t %= 1003L;
                    f += left.first * right.first;
                    f %= 1003L;
                    f += left.second * right.second;
                    f %= 1003L;
                }
            }
        }
        
        Pair result = new Pair(t, f);
        cache.put(key, result);
        return result;
    }
    
    public static int countWays(int n, String s){
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 'T') arr[i] = '1';
            else if(arr[i] == 'F') arr[i] = '0';
        }
        
        cache = new HashMap<>();
        return (int)(helper(0, s.length() - 1, arr).first);
    }
}