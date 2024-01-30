class Solution {
    public int evalRPN(String[] tokens) {
        int ans = 0;
        Stack<String> st = new Stack<>();
        int count = 1;
        for(int i = 0; i < tokens.length; i++){            
            if(tokens[i].equals("+") || tokens[i].equals("-")  || tokens[i].equals("*") || tokens[i].equals("/")){
                int b = Integer.parseInt(st.pop());
                int a = Integer.parseInt(st.pop());
                if(tokens[i].equals("+")) ans = a + b;
                else if(tokens[i].equals("-")) ans = a - b;
                else if(tokens[i].equals("*")) ans = a * b;
                else if(tokens[i].equals("/")) ans = a / b;
                st.push(ans + "");
            }
            else{
                st.push(tokens[i]);
            }
        }   
        return Integer.parseInt(st.pop());
    }
}