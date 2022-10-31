class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length(), left = 0, right = n;
        int[] res = new int[n + 1];
        for (int i = 0; i < n; ++i)
            res[i] = s.charAt(i) == 'I' ? left++ : right--;
        res[n] = left;
        return res;
    }
}