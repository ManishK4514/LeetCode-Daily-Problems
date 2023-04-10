class Solution {
public:
    bool isValid(string s) {
        stack<char> st;
        for(int i = 0; i < s.length(); i++){
            if(!st.empty() && st.top() == '(' && s[i] == ')') st.pop();
            else if(!st.empty() && st.top() == '[' && s[i] == ']') st.pop();
            else if(!st.empty() && st.top() == '{' && s[i] == '}') st.pop();
            else st.push(s[i]);
        }
        return st.empty();
    }
};