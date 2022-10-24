class Solution {
    public String reversePrefix(String word, char ch) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while(i < word.length()){
            sb.append(word.charAt(i));
            if(word.charAt(i) == ch){
                break;
            }            
            i++;
        }
        if(sb.length() == word.length() && word.charAt(word.length() - 1) != ch){
            return word;
        }
        sb.reverse();
        String ans = sb.toString();
        ans += word.substring(i + 1, word.length());
        return ans;
    }
}