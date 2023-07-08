//{ Driver Code Starts
import java.util.*;
class Triplets{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] a=new int[n];
			for(int i=0;i<n;i++){
				a[i]=sc.nextInt();
			}
			Solution g=new Solution();
			if(g.findTriplets(a,n))
				System.out.println("1");
			else
				System.out.println("0");
			
		}
	}
}
// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    // arr[]: input array
    // n: size of the array
    //Function to find triplets with zero sum.
    public boolean threeSum(int[] nums) {   
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int j = i + 1, k = n - 1;
            while(j < k){
                if(nums[i] + nums[j] + nums[k] == 0){
                    return true;
                }
                else if(nums[i] + nums[j] + nums[k] < 0) j++;
                else k--;
            }
        }
        return false;
    }
	public boolean findTriplets(int arr[] , int n)
    {
        return threeSum(arr);
    }
}