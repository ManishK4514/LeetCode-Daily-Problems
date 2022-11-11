class Solution {
    public String countAndSay(int n) {
        StringBuilder str = new StringBuilder();
        // base Value;
        str.append("1");
        int count = 1;
        for(int i = 2; i <= n; i++){
            StringBuilder temp = new StringBuilder();
            str.append("$");
            for(int j = 1; j < str.length(); j++){                
                if(str.charAt(j) == str.charAt(j - 1)){
                    count++;
                }
                else{
                    temp.append(count);
                    temp.append(str.charAt(j - 1));
                    count = 1;
                }
            }
            str = temp;
        }
        return str.toString();
    }
}