class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder, (a, b)->{
            return a.length() - b.length();
        });
        int n = folder.length;
        List<String> ans = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            String curr = folder[i];
            String temp = "";
            boolean flag = false;
            for(int j = 0; j < folder[i].length(); ){
               int k = j + 1, p = 1;
               while(k < folder[i].length() && folder[i].charAt(k) != '/') {
                   k++; p++;
               }
               temp += folder[i].substring(j, j + p);
               if(set.contains(temp)){
                   flag = true;
                   break;
               }
               j += p; 
            }
            if(!flag) {
                ans.add(folder[i]);
                set.add(folder[i]);
            }            
        }
        return ans;
    }
}