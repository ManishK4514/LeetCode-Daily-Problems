class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        vector<int> ans;
        if(s.length() < p.length()){
            return ans;            
        }
        vector<int> map1 (26, 0);
        vector<int> map2 (26, 0);
        int l = 0, r = 0;
        while(r < p.length()){
            map1[p[r] - 'a']++;
            map2[s[r] - 'a']++;
            r++;
        }
        
        if(map1 == map2){
            ans.push_back(l);
        }
        while(r < s.length()){
            map2[s[r] - 'a']++;
            map2[s[l] - 'a']--;
            l++; r++;
            if(map1 == map2){
                ans.push_back(l);
            }            
        }
        return ans;
    }
};