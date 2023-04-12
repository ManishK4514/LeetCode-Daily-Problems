class Solution {
public:
    string simplifyPath(string path) {
        stack<string> st;
        for(int i = 0; i < path.length(); i++){
            if(path[i] == '/') continue;
            string curr = "";
            while(i < path.length() && path[i] != '/'){
                curr += path[i]; i++;
            }
            if(curr == ".") continue;
            else if(curr == "..") {
                if(!st.empty()) st.pop(); 
                continue;
            }
            else st.push(curr);
        }
        string res = "";
        while(!st.empty()){
            res =  "/" + st.top() + res;
            st.pop();
        }
        if(res.length() == 0) return "/";
        return res;
    }
};