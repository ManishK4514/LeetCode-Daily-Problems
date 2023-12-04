class Solution {
    public String largestGoodInteger(String num) {
        char[] ans = new char[3];
        boolean possible = false;
        for(int i = 2; i < num.length(); i++) {
            char ch = num.charAt(i);
            if(num.charAt(i - 1) == ch && num.charAt(i - 2) == ch) {
                if(!possible || ch > ans[0]) {
                    possible = true;
                    ans[0] = ch; ans[1] = ch; ans[2] = ch;
                }
            }
        }

        if(!possible) return "";

        return String.valueOf(ans);
    }
}