class Solution {
public:
    string convert(string s, int numRows) {
        vector<string> arr (numRows, "");
        int i = 0;
        while(i < s.size()){
            for(int j = 0; j < arr.size(); j++){
                if(i < s.size()) arr[j] += s[i++];
            }
            for(int j = arr.size() - 2; j >= 1; j--){
                if(i < s.size()) arr[j] += s[i++];
            }
        }
        string ans = "";
        for(int j = 0; j < arr.size(); j++){
            ans += arr[j];
        }
        return ans;
    }
};