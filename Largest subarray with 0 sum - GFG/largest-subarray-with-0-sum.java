//{ Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG
{
    int maxLen(int arr[], int n)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, ans = 0, target = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i];
            if(sum == 0) ans = Math.max(ans, i + 1);
            if(map.containsKey(sum)){
                ans = Math.max(ans, i - map.get(sum));
            }
            if(!map.containsKey(sum)) map.put(sum, i);
            // System.out.print(sum + " ");
        }
        // System.out.println();
        return ans;
    }
}