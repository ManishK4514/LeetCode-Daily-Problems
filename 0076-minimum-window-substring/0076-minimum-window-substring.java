class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0) + 1);
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        int i = 0, j = 0, mct = 0, dmct = t.length();
        String ans = "";
        while(true){
            boolean f1 = false;
            boolean f2 = false;

            while(j < s.length() && mct < dmct){
                map1.put(s.charAt(j), map1.getOrDefault(s.charAt(j), 0) + 1);
                if(map2.containsKey(s.charAt(j)) && map1.get(s.charAt(j)) <= map2.get(s.charAt(j))){
                    mct++;
                }
                j++;
                f1 = true;
            }
            while(i < j && mct == dmct){
                String temp = s.substring(i, j);
                if(ans.length() == 0 || ans.length() > temp.length()){
                    ans = temp;
                }

                map1.put(s.charAt(i), map1.get(s.charAt(i)) - 1);
                
                if(map2.containsKey(s.charAt(i)) && map1.get(s.charAt(i)) < map2.get(s.charAt(i))){
                    mct--;
                }
                i++;
                f2 = true;
            }
            if(!f1 && !f2){
                break;
            }
        }
        return ans;
    }
}