class Solution {
public:
    string predictPartyVictory(string senate) {
        queue<int> R;
        queue<int> D;
        for(int i = 0; i < senate.length(); i++){
            if(senate[i] == 'R') R.push(i);
            else D.push(i);
        }
        int idx = senate.length();
        while(!R.empty() && !D.empty()){
            int currR = R.front();
            int currD = D.front();
            R.pop(); D.pop();
            if(currR < currD){
                R.push(idx++);
            }
            else D.push(idx++);
        }
        return R.empty() ? "Dire" : "Radiant";
    }
};