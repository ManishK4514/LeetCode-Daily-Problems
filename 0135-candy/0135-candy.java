class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length, ans = 0;
        int[] candy = new int[n];
        Arrays.fill(candy, 1);
        
        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
        }

        for(int i = n - 2; i >= 0; i--){
            if(ratings[i] > ratings[i + 1] && candy[i] <= candy[i + 1]) {
                candy[i] = candy[i + 1] + 1;
            }
        }

        for(int i = 0; i < n; i++) ans += candy[i];
        return ans;
    }
}