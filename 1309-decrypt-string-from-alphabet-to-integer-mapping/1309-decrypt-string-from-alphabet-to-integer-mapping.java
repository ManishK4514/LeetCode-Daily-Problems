class Solution {
    public String freqAlphabets(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            st.push(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            if(st.peek() == '#'){
                st.pop();
                StringBuilder temp = new StringBuilder();
                temp.append(st.pop());
                temp.append(st.pop());
                temp.reverse();
                int num = Integer.parseInt(temp.toString());
                sb.append((char)(num + 96));
            }
            else{
                int num = st.pop() - '0';
                sb.append((char)(num + 96));
            }
        }
        sb.reverse();
        return sb.toString();
    }
}