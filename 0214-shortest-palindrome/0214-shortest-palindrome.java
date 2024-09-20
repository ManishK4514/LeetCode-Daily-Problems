class Solution {
    public String shortestPalindrome(String s) {
        String revS = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + revS;
        
        int[] kmpTable = buildKMPTable(combined);        
        int longestPalindromePrefix = kmpTable[kmpTable.length - 1];
        
        String suffixToAdd = s.substring(longestPalindromePrefix);
        return new StringBuilder(suffixToAdd).reverse().toString() + s;
    }

    private int[] buildKMPTable(String str) {
        int n = str.length();
        int[] table = new int[n];
        int j = 0; 
        
        for (int i = 1; i < n; i++) {
            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = table[j - 1];
            }
            
            if (str.charAt(i) == str.charAt(j)) {
                j++;
            }
            
            table[i] = j;
        }
        
        return table;
    }
}
