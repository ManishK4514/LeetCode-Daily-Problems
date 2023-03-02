class Solution {
    int idx = 0;
    public int update(int n, char[] temp, char ch){
        temp[idx++] = ch;
        String num = Integer.toString(n);
        for(int i = 0; i < num.length(); i++){
            temp[idx++] = num.charAt(i);
        }
        return num.length();
    }
    public int compress(char[] chars) {
        int n = chars.length;
        int count = 1, ans = 0;
        for(int i = 1; i < n; i++){
            if(chars[i] != chars[i - 1]){
                if(count > 1) ans += update(count, chars, chars[i - 1]);
                else chars[idx++] = chars[i - 1];
                ans += 1;           
                count = 1;
            }
            else count++;
        }
        if(count > 1) ans += update(count, chars, chars[n - 1]);
        else chars[idx++] = chars[n - 1];
        ans += 1;
        return ans;
    }
}