class Solution {
    public String largestNumber(int[] nums) {
        List<String> ls = new ArrayList<>();
        for(int num : nums) ls.add(num + "");

        Collections.sort(ls, (a, b) -> (b + a).compareTo(a + b));
        
        StringBuilder res = new StringBuilder();
        for (String str : ls) res.append(str);

        if(res.charAt(0) == '0') return "0";        
        return res.toString();
    }
}