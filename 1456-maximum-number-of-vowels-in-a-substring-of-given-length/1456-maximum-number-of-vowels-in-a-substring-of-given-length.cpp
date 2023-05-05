class Solution {
public:
    bool checkVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    int maxVowels(string s, int k) {
        int count = 0, ans = 0;
        for(int i = 0, j = 0; j < s.length(); j++){
            if(checkVowel(s[j])) count++;
            if(j >= k) if(checkVowel(s[i++])) count--;
            ans = max(ans, count);
        }
        return ans;
    }
};