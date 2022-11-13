//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends



class Solution
{
    
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        int temp[] = nums.clone();
        Arrays.sort(temp);
        for(int i = 0; i < nums.length; i++){
            map.put(temp[i], i);
        }
        int ans = 0;
        for(int i = 0; i < temp.length; i++){
            while(map.get(nums[i]) != i){
                int t1 = nums[i];
                int k = map.get(nums[i]);
                int t2 = nums[map.get(nums[i])];
                nums[i] = t2;
                nums[k] = t1;
                ans++;
            }
        }
        return ans;
    }
}