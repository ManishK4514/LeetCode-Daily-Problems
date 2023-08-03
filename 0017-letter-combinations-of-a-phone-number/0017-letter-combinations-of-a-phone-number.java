class Solution {
    public static void findCombination(int idx, String digits, List<String> ans, StringBuilder sb, HashMap<Character, String> map){
        if(idx == digits.length()){
            ans.add(sb.toString());
            return;
        }
        String curr = map.get(digits.charAt(idx));
        for(int k = 0; k < curr.length(); k++){
            sb.append(curr.charAt(k));
            findCombination(idx + 1, digits, ans, sb, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0){
            return ans;
        }
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        findCombination(0, digits, ans, new StringBuilder(), map);
        return ans;
    }
}