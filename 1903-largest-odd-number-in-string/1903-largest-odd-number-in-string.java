class Solution {
    public String largestOddNumber(String num) {
        int i = num.length() - 1; 
        while(i >= 0 && ((num.charAt(i) - '0') & 1) == 0) i--;
        return num.substring(0, i + 1);
    }
}