class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        int n = num.length();

        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && num.charAt(i) < st.peek() && k > 0) {
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }

        while(k-->0 && !st.isEmpty()) st.pop();

        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()) ans.append(st.pop());
        int j = ans.length() - 1;
        while(j >= 0 && ans.charAt(j) == '0') ans.deleteCharAt(j--);

        return ans.length() == 0 ? "0" : ans.reverse().toString();
    }
}