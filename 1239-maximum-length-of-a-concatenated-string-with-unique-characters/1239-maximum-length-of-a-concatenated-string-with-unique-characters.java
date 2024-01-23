class Solution {
    public boolean hasCommon(StringBuilder s1, StringBuilder s2) {
        int[] arr = new int[26];
        
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            if (arr[ch - 'a'] > 0)
                return true;
            arr[ch - 'a']++;
        }
        
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            if (arr[ch - 'a'] > 0)
                return true;
        }
        
        return false;
    }
    public int helper(List<String> arr, int idx, StringBuilder temp, HashMap<StringBuilder, Integer> dp){
        // base case
        if(idx >= arr.size()){
            return temp.length();
        }

        if (dp.containsKey(temp.toString()))
            return dp.get(temp.toString());

        int exclude = 0, include = 0;
        
        if(hasCommon(new StringBuilder(arr.get(idx)), temp)){  
            exclude = helper(arr, idx + 1, temp, dp); 
        }
        else{
            exclude = helper(arr, idx + 1, temp, dp); 
            temp.append(arr.get(idx));             
            include = helper(arr, idx + 1, temp, dp); 
            temp.delete(temp.length() - arr.get(idx).length(), temp.length());
        }   

        int maxLength = Math.max(include, exclude);
        dp.put(new StringBuilder(temp), maxLength);
        
        return maxLength;
    }
    public int maxLength(List<String> arr) {
        HashMap<StringBuilder, Integer> dp = new HashMap<>();
        return helper(arr, 0, new StringBuilder(), dp);
    }
}