class Solution {
public:
    double average(vector<int>& salary) {
        int maxi = INT_MIN;
        int mini = INT_MAX;
        double sum = 0;
        
        for(int i = 0; i < salary.size(); i++){
            sum += salary[i];
            maxi = max(maxi, salary[i]);
            mini = min(mini, salary[i]);
        }

        sum -= maxi + mini;

        return sum / (salary.size() - 2);
    }
};