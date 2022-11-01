class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0, ans = 0;
        while(j < fruits.length){
            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);
            while(map.size() > 2){
                map.put(fruits[i], map.get(fruits[i]) - 1);
                if(map.get(fruits[i]) == 0){
                    map.remove(fruits[i]);                    
                }
                i++;
            }
            ans = Math.max(ans, (j - i) + 1);
            j++;
        }
        return ans;
    }
}