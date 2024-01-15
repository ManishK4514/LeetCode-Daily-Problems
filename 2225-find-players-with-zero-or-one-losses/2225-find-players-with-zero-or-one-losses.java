class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int n = 1;

        for(int[] match : matches) {
            n = Math.max(n, Math.max(match[0], match[1]));
        }

        int[] loose = new int[n + 1];

        for(int[] match : matches) {
            int win = match[0];
            int loss = match[1];
            
            if(loose[win] == 0) loose[win] = -1;

            if(loose[loss] == -1) loose[loss] = 1;
            else loose[loss]++;
        }

        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> notLost = new LinkedList<>();
        List<Integer> lostOneMatch = new LinkedList<>();

        for(int i = 0; i < loose.length; i++) {
            if(loose[i] == -1) notLost.add(i);
            else if(loose[i] == 1) lostOneMatch.add(i);
        }

        ans.add(notLost);
        ans.add(lostOneMatch);

        return ans;
    }
}