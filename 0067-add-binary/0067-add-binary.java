class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int len = Math.max(a.length(), b.length());
        int remainingLength = len - Math.min(a.length(), b.length());
        for(int i = 0; i < remainingLength; i++){
            sb.append('0');
        }
        if (a.length() < b.length()) {
            a = sb.toString() + a;
        }  
        else b = sb.toString() + b;

        int carry = 0;
        StringBuilder ans = new StringBuilder();
        for(int i = len - 1; i >= 0; i--){
            int sum = carry + (a.charAt(i) - '0') + (b.charAt(i) - '0');
            if(sum == 0){
                ans.append("0");
                carry = 0;
            }
            else if(sum == 1){
                ans.append("1");
                carry = 0;
            }
            else if(sum == 2){
                ans.append("0");
                carry = 1;
            }
            else{
                ans.append("1");
                carry = 1;
            }
        }
        if(carry > 0) ans.append(carry + ""); 
        return ans.reverse().toString();
    }
}