class Solution {
    public String firstPalindrome(String[] words) {
        StringBuffer sb = null;
        for(String s:words){
            sb = new StringBuffer(s);
            if(sb.reverse().toString().equals(s))
                return s;
        }
        return "";
    }
}