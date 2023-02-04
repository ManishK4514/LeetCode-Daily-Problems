class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        if(s1.size() > s2.size()) return false;
        vector<int> mp1 (26, 0);
        vector<int> mp2 (26, 0);
        int l = 0, r = 0, len = s1.size();
        while(r < len){
            mp1[s1[r] - 'a']++;
            mp2[s2[r] - 'a']++;
            r++;
        }
        if(mp1 == mp2) return true;
        while(r < s2.size()){
            mp2[s2[r] - 'a']++;
            mp2[s2[l] - 'a']--;
            if(mp1 == mp2) return true;
            r++; l++;
        }
        return false;
    }
};