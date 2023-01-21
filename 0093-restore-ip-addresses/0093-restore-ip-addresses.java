class Solution {
    public boolean isValid(String s){
        if(s.charAt(0) == '0' && s.length() >= 2) return false;
        if(s.charAt(0) == '0' && s.length() == 1) return true;
        int x = Integer.parseInt(s);
        if(x >= 0 && x <= 255) return true;
        else return false;
    }
    public void helper(int idx, String s, String res, List<String> ans, int count){
        if(count >= 4){
            if(idx == s.length()){
                res = res.substring(0, res.length() - 1);
                ans.add(res);
            }
            return;
        }
        
        for(int i = idx; i < idx + 3; i++){
            if(i < s.length()){
                String curr = s.substring(idx, i + 1);
                if(isValid(curr)){
                    helper(i + 1, s, res + curr + "." , ans, count + 1);
                }
            }
        }
    }      
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        helper(0, s, "", ans, 0);
        return ans;
    }
}