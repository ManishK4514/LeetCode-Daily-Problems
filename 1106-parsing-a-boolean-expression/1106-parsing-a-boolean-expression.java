class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> st = new Stack();

        for(char ch : expression.toCharArray()) {
            if(ch == '&' || ch == '|' || ch == '!' || ch == 't' || ch == 'f') st.push(ch);
            else if(ch == ')') {
                boolean trueFound = false;
                boolean falseFound = false;

                while(st.peek() == 't' || st.peek() == 'f') {
                    if(st.peek() == 't') trueFound = true;
                    else falseFound = true;
                    st.pop();
                }

                char operator = st.pop();

                if(operator == '|') st.push(trueFound ? 't' : 'f');
                else if(operator == '&') st.push(!falseFound ? 't' : 'f');
                else st.push(!trueFound ? 't' : 'f');
            }
        }

        return st.peek() == 't';
    }
}