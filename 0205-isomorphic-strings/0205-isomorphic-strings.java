class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] map1 = new char[256];
        char[] map2 = new char[256];
        int n = s.length();

        for(int i = 0; i < n; i++) {
            int index1 = (int)s.charAt(i);
            int index2 = (int)t.charAt(i);
            
            if(map1[index1] == 0) {
                if(map2[index2] != 0) return false;                
                map1[index1] = t.charAt(i);
                map2[index2] = s.charAt(i);
            }
            else if(map1[index1] != t.charAt(i)) return false;
        }
        
        return true;
    }
}
