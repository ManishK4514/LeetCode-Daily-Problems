class Solution {
public:
    bool isAlienSorted(vector<string>& words, string order) {
        int n = words.size();
        unordered_map<char, char> map;
        for(int i = 0; i < order.size(); i++){
            map[order[i]] = i;
        }
        for(int i = 0; i < n- 1; i++){
            string w1 = words[i];
            string w2 = words[i + 1];
            int len = min(w1.size(), w2.size());
            for(int j = 0; j < len; j++){
                if(map[w1[j]] < map[w2[j]]) break;
                if(map[w1[j]] > map[w2[j]]) return false;
                if(j == len - 1 && w1.size() > w2.size()) return false;
            }
        }
        return true;
    }
};