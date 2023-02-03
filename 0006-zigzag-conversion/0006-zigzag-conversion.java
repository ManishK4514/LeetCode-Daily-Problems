class Solution {
    public String convert(String s, int numRows) {
        StringBuffer[] arr = new StringBuffer[numRows];
        for (int i = 0; i < arr.length; i++) arr[i] = new StringBuffer();
        int i = 0;
        while(i < s.length()){
            for(int j = 0; j < arr.length; j++){
                if(i < s.length()) arr[j].append(s.charAt(i++) + "");
            }
            for(int j = arr.length - 2; j >= 1; j--){
                if(i < s.length()) arr[j].append(s.charAt(i++) + "");
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < arr.length; j++){
            sb.append(arr[j]);
        }
        return sb.toString();
    }
}