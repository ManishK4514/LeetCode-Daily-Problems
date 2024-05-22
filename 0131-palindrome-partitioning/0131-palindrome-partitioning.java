class Solution {
    public boolean isPalindrome(int l, int r, String s) {
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) return false;
            l++; r--;
        }
        return true;
    }

    public void helper(int i, String s, List<List<String>> ans, List<String> palindrome) {
        if(i == s.length()) {
            ans.add(new LinkedList<>(palindrome));
            return;
        } 

        for(int j = i; j < s.length(); j++) {
            if(isPalindrome(i, j, s)) {
                palindrome.add(s.substring(i, j + 1));
                helper(j + 1, s, ans, palindrome);
                palindrome.remove(palindrome.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new LinkedList<>();
        helper(0, s, ans, new LinkedList<>());
        return ans;
    }
}