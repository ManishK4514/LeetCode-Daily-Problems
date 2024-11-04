class Solution {
    public String compressedString(String word) {
        char ch = '$';
        int count = 0;
        StringBuilder sb = new StringBuilder();
        
        for(char it : word.toCharArray()) {
            if(ch == it) {
                if(count == 9) {
                    sb.append(count + "" + ch);
                    count = 1;
                }
                else count++;                
            }
            else {
                if(ch != '$') sb.append(count + "" + ch);
                ch = it;
                count = 1;
            }
        }

        sb.append(count + "" + ch);

        return sb.toString();
    }
}