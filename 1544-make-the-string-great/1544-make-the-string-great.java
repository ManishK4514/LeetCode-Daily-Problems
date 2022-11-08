class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(!st.empty() && (char)(s.charAt(i) + 32) == st.peek()){
                st.pop();                
            }
            else if(!st.empty() && (char)(s.charAt(i) - 32) == st.peek()){
                st.pop();
            }
            else{
                st.push(s.charAt(i));
            }
        }
        char[] ch = new char[st.size()];
        int i = st.size() - 1;
        while(!st.empty()){
            ch[i--] = st.pop();
        }
        return new String(ch);
    }
}