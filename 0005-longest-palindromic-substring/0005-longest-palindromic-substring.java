class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int maxLen = 1;
        int l, r;
        for(int i = 0; i < s.length(); i++){
            // even
            l=i-1;
            r=i ; 
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                if(r-l+1>maxLen){
                    maxLen=r-l+1;
                    start=l;
                }
                l-=1;
                r+=1;
            }            
            // odd    
            l=i-1;
            r=i+1;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                if( r-l+1>maxLen){
                    maxLen=r-l+1;
                    start=l;
                }    
                l-=1;
                r+=1;  
            }            
        }  
        return s.substring(start, start + maxLen);
    }
}