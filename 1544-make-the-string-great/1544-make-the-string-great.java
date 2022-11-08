class Solution {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder(s);
        while(true){
            boolean flag = true;
            for(int i = 0; i < sb.length(); i++){
                if(sb.charAt(i) >= 'A' && sb.charAt(i) <= 'Z'){
                    if(i < sb.length() - 1 && (char)(sb.charAt(i) + 32) == sb.charAt(i+1)){
                        sb.deleteCharAt(i);
                        sb.deleteCharAt(i);
                        flag = false;
                    }
                    else if(i > 0 && (char)(sb.charAt(i) + 32) == sb.charAt(i-1)){
                        sb.deleteCharAt(i - 1);
                        sb.deleteCharAt(i - 1);
                        flag = false;
                    }
                }
            }
            if(flag){
                break;
            }
        }
        return sb.toString();
    }
}