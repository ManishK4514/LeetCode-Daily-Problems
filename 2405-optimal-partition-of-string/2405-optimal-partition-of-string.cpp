class Solution {
public:
    int partitionString(string s) {
        vector<int> mp(26, 0);
        int count = 1;
        for(int i = 0; i < s.length(); i++){
            if(mp[(s[i] - 'a')] > 0){
                for(int j = 0; j < 26; j++) mp[j] = 0; 
                count++;
            }
            mp[s[i] - 'a']++;
        }
        return count;
    }
};