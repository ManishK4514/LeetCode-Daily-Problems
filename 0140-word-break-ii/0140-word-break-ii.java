class Solution {
    public void helper(int i, String s, HashSet<String> set, List<String> res, List<String> ds) {
        if(i >= s.length()) {
            StringBuilder curr = new StringBuilder();
            for(int j = 0; j < ds.size(); j++) {
                curr.append(ds.get(j));
                if(j < ds.size() - 1) curr.append(" ");
            }
            res.add(curr.toString());
            return;
        }

        StringBuilder sb = new StringBuilder();

        for(int j = i; j < s.length(); j++) {
            sb.append(s.charAt(j));
            if(set.contains(sb.toString())) {
                ds.add(sb.toString());
                helper(j + 1, s, set, res, ds);
                ds.remove(ds.size() - 1);
            }
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet(wordDict);
        List<String> res = new LinkedList<>();
        helper(0, s, set, res, new LinkedList<>());
        return res;
    }
}