//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            
            Compute obj = new Compute();
            long answer[] = obj.printFirstNegativeInteger(a, n, k);
            int sz = answer.length;
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<sz;i++)
                output.append(answer[i]+" ");
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Compute {
    
    public long[] printFirstNegativeInteger(long arr[], int N, int k)
    {
        ArrayList<Long> res = new ArrayList<>();
        ArrayDeque<Long> list = new ArrayDeque<>();
        boolean flag = true;
        for(int i = 0; i < k; i++){
            if(arr[i] < 0 && flag == true){
                flag = false;
                res.add(arr[i]);
            }
            if(arr[i] < 0){
                list.add(arr[i]);
            }
        }
        if(flag == true){
            res.add((long)(0));
        }
        if(!list.isEmpty() && arr[0] == list.getFirst()){
            list.removeFirst();
        }
        int i = 1;

        for(int j = k; j < arr.length; j++){
            if(arr[j] < 0){
                list.add(arr[j]);
            }
            if(list.isEmpty()){
                res.add((long)(0));
            }
            else{
                res.add(list.getFirst());
            }
            if(!list.isEmpty() && arr[i] == list.getFirst()){
                list.removeFirst();
            }
            i++;
        }
        long[] ans = new long[res.size()];
        for(int j = 0; j < res.size(); j++){
            ans[j] = res.get(j);
        }
        return ans;
    }
}