class Solution {
    public String reverseWords(String str) {
        StringBuilder ans = new StringBuilder();
        int j = str.length();
        int k = 0;
        while(str.charAt(k) == ' '){
            k++;
        }
        str = str.substring(k, j);
        j = str.length();
        int i = str.length() - 1;
        while(i >= 0){
            while(str.charAt(i) == ' '){
                i--;
                j--;
            }
            while(i >= 0 && str.charAt(i) != ' '){
                i--;
            }
            ans.append(str.substring(i + 1, j));
            ans.append(" ");
            j = i;
            i--;
        }
        ans.deleteCharAt(ans.length() - 1);
        return ans.toString();
    }
}