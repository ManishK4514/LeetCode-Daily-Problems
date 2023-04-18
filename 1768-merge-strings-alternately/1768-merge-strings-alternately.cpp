class Solution {
public:
    string mergeAlternately(string word1, string word2) {
        int n = word1.length(), m = word2.length(), i = 0, j = 0;
        string res = "";
        while(i < n || j < m){
            if(i < n) res += word1[i++];
            if(j < m) res += word2[j++];
        }
        return res;
    }
};