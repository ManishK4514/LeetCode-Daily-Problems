class Solution {
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        if(n % 2 == 0){
            int i = 1;
            while(i < n){
                sb.append("a");
                i++;
            }
            sb.append("b");
            return sb.toString();
        }
        else{
            int i = 1;
            while(i <= n){
                sb.append("a");
                i++;
            }
            return sb.toString();
        }
    }
}