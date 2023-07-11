//{ Driver Code Starts
import java.util.*;

class WildcardPattern
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String pat = sc.nextLine();
			String text = sc.nextLine();
			Solution g = new Solution();
			System.out.println(g.wildCard(pat,text));
			t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    public static boolean isAllStars(String p, int idx){
        while(idx > 0) {
            if(p.charAt(idx - 1) != '*') return false;
            idx--;
        } 
        return true;
    }
    
    int wildCard(String p, String s)
    {
        int n = s.length();
        int m = p.length();

        // shifting to the right by 1-index
        boolean[][] dp = new boolean[n + 1][m + 1];
        
        // base cases
        dp[0][0] = true;
        for(int i = 0; i <= n; i++) dp[i][0] = false;
        for(int j = 0; j <= m; j++) dp[0][j] = isAllStars(p, j);

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?'){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if(p.charAt(j - 1) == '*'){
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }    
                else dp[i][j] = false;  
            }
        }

        return dp[n][m] == true ? 1 : 0;
    }
}
