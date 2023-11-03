class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int k = 1, m = target.length;
        for(int i = 0; i < m; i++) {
            if(target[i] == k) ans.add("Push");
            else {
                int diff = target[i] - k;
                while(diff-- > 0) {
                    ans.add("Push");
                    ans.add("Pop");
                }
                ans.add("Push");
                k = target[i];
            }
            k++;
        }
        return ans;
    }
}