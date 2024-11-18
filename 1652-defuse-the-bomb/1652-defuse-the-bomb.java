class Solution {
    public int[] decrypt(int[] code2, int k) {
        int n = code2.length, sum = 0;
        int[] code = new int[n + n];
        for(int i = 0; i < code.length; i++) {
            code[i] = code2[i % n];
        }

        int[] ans = new int[n];

        if(k == 0) return ans;

        int[] suffix = new int[n + n];

        for(int i = (2 * n) - 1; i >= 0; i--) {
            suffix[i] += (i < (2 * n) - 1 ? suffix[i + 1] : 0) + code[i];
        }

        int prefix = 0, kk = Math.abs(k), j = 0;

        for(int i = 0; i < n; i++) {
            if(k > 0) ans[i] = suffix[i + 1] - suffix[i + k + 1];       
        }

        if(k > 0) return ans;

        for(int i = n - kk; i < n + n; i++) {
            if(i >= n) ans[j++] = prefix;     
            prefix +=  code[i];
            if(i >= n) prefix -= code[i - kk];
        }

        return ans;
    }
}