class Solution {
    public int[] timeDiff(List<String> timePoints, int i, int j) {
        int h1 = Integer.parseInt(timePoints.get(i).substring(0, 2));
        int m1 = Integer.parseInt(timePoints.get(i).substring(3));
    
        int h2 = Integer.parseInt(timePoints.get(j).substring(0, 2));
        int m2 = Integer.parseInt(timePoints.get(j).substring(3));
        int totalMinutes1 = h1 * 60 + m1;
        int totalMinutes2 = h2 * 60 + m2;

        return new int[]{totalMinutes1, totalMinutes2};
    }
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size(), ans = (int)(1e9);

        Collections.sort(timePoints, (a, b)->{
            int h1 = Integer.parseInt(a.substring(0, 2));
            int m1 = Integer.parseInt(a.substring(3));
    
            int h2 = Integer.parseInt(b.substring(0, 2));
            int m2 = Integer.parseInt(b.substring(3));

            if(h1 == h2) return m1 - m2;
            return h1 - h2;
        });

        for(int i = 1; i < n; i++) {
            int j = i - 1;

            int[] timeDiff = timeDiff(timePoints, i, j);

            int totalMinutes1 = timeDiff[0];
            int totalMinutes2 = timeDiff[1];
    
            int diffMinutes = Math.abs(totalMinutes1 - totalMinutes2);
            int wrappedDiffMinutes = 1440 - diffMinutes;
    
            ans = Math.min(ans, Math.min(diffMinutes, wrappedDiffMinutes));
        }

        int[] timeDiff = timeDiff(timePoints, 0, n - 1);

        int totalMinutes1 = timeDiff[0];
        int totalMinutes2 = timeDiff[1];

        int diffMinutes = Math.abs(totalMinutes1 - totalMinutes2);
        int wrappedDiffMinutes = 1440 - diffMinutes;

        ans = Math.min(ans, Math.min(diffMinutes, wrappedDiffMinutes));

        return ans;
    }
}