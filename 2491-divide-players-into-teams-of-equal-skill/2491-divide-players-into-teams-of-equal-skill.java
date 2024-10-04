class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int l = 0, r = skill.length - 1;
        long ans = 0, requiredSkill = skill[l] + skill[r];

        while(l < r) {
            if(requiredSkill != skill[l] + skill[r]) return -1;
            ans += 1L * skill[l] * skill[r];
            l++; r--;
        }

        return ans;
    }
}