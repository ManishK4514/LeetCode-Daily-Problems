class Solution {
    public int maximumLength(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        int n = s.length(), ans = -1;

        for(int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            char ch = s.charAt(i);
            for(int j = i; j < n; j++) {                
                if(ch != s.charAt(j)) break;
                sb.append(s.charAt(j));
                map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
                if(map.get(sb.toString()) >= 3) ans = Math.max(ans, sb.length());
            }
        }

        return ans;
    }
}