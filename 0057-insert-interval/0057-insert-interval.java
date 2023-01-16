class Solution {
    public int[][] makeRes(ArrayList<int[]> list){
        int[][] res = new int[list.size()][2];
        int i = 0;
        for(int[] nums : list){
            res[i++] = nums;
        }
        return res;
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        ArrayList<int[]> list = new ArrayList<>();
        for(int[] interval: intervals){
            if(interval[1] < newInterval[0]){
                list.add(interval);
            }
            else if(interval[0] > newInterval[1]){
                list.add(newInterval);
                newInterval = interval;
            }
            else{
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }        
        list.add(newInterval);
        int[][] res = makeRes(list);
        return res;
    }
}