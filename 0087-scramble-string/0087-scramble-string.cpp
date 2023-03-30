class Solution {
public:
    unordered_map<string, bool> map;
    bool helper(const string& s1, const string& s2) {
        if(s1 == s2) return map[s1 + "#" + s2] = true;
        if(s1.length() == 1) return false;
        if(map.count(s1 + "#" + s2)) return map[s1 + "#" + s2];
        for(int k = 1; k <= s1.length() - 1; k++){
            if (helper(s1.substr(0,k), s2.substr(0,k)) 
             && helper(s1.substr(k), s2.substr(k))) return map[s1 + "#" + s2] = true;
            if (helper(s1.substr(0,k), s2.substr(s2.length()-k)) 
             && helper(s1.substr(k), s2.substr(0,s2.length()-k))) return map[s1 + "#" + s2] = true;
        }        
        return map[s1 + "#" + s2] = false;
    }
public:
    bool isScramble(const string& s1, const string& s2) {
        if(s1.length() != s2.length()) return false;
        return helper(s1, s2);
    }
};