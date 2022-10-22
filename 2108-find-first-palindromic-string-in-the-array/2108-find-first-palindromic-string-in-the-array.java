class Solution {
    public boolean checkPalindrome(String str){
        int i = 0, j = str.length() - 1;
        while(i <= j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public String firstPalindrome(String[] words) {
        boolean possible;
        for(int i = 0; i < words.length; i++){
            possible = checkPalindrome(words[i]);
            if(possible){
                return words[i];
            }
        }
        return "";
    }
}