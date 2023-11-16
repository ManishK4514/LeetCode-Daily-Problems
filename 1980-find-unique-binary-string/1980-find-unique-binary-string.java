class Solution {
    public boolean helper(int i, HashSet<String> set, StringBuilder sb) {
        if(i == 0) return !set.contains(sb.toString());
        
        sb.append("0");
        if(helper(i - 1, set, sb)) return true;
        sb.deleteCharAt(sb.length() - 1);

        sb.append("1");
        if(helper(i - 1, set, sb)) return true;
        sb.deleteCharAt(sb.length() - 1);

        return false;
    }
    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) set.add(nums[i]);
        StringBuilder sb = new StringBuilder();       
        helper(nums[0].length(), set, sb);
        return sb.toString();
    }
}