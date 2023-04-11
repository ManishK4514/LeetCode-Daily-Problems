class Solution {
public:
    string removeStars(string s) {
        string str = "";
        for(int i = 0; i < s.length(); i++){
            if(str.length() > 0 && s[i] == '*') str.erase(str.length() - 1);
            else str += s[i];
        }
        return str;
    }
};