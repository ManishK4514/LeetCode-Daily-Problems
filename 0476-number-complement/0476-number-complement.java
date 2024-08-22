class Solution {
    public int findComplement(int num) {
        int i = 0, ans = 0;
        while(num > 0) {
            if((num & 1) != 1) ans += (1 << i);
            num = num >> 1;
            i++;
        }
        return ans;
    }
}