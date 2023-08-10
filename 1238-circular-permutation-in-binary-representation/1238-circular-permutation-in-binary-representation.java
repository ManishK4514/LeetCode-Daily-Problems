class Solution {
    public boolean helper(int n, int start, HashSet<Integer> set, List<Integer> ans){
        if(ans.size() == Math.pow(2, n)){
            int last = ans.get(ans.size() - 1);
            int x = start ^ last;
            return (x & (x - 1)) == 0;
        }

        int last = ans.get(ans.size() - 1);

        for(int i = 0; i < 16; i++){
            int curr = last ^ (1 << i);

            if(curr <= Math.pow(2, n) - 1 && !set.contains(curr)){
                set.add(curr);
                ans.add(curr);
                if(helper(n, start, set, ans)) return true;
                ans.remove(ans.size() - 1);
                set.remove(curr);
            }
        }
        return false;
    }
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        ans.add(start);
        set.add(start);

        helper(n, start, set, ans);
        return ans;
    }
}