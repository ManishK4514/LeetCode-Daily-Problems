class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> res = new ArrayList<>();        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < matches.length; i++){
            map.put(matches[i][1], map.getOrDefault(matches[i][1], 0) + 1);
        }
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for(int i = 0; i < matches.length; i++){
            if(map.get(matches[i][1]) == 1){
                list2.add(matches[i][1]);
            }
            if(!map.containsKey(matches[i][0])){
                list1.add(matches[i][0]);
                map.put(matches[i][0], 2);
            }
        }
        Collections.sort(list1);
        Collections.sort(list2);
        res.add(list1);
        res.add(list2);
        return res;
    }
}