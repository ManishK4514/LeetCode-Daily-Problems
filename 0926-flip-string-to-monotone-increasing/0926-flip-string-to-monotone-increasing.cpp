class Solution {
public:
    int minFlipsMonoIncr(string s) {
        int flips = 0, ones = 0;
        for(char ch : s){
            if(ch == '1'){
                ones++;
            }
            else flips++;
            flips = min(flips, ones);
        }
        return flips;
    }
};