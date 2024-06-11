class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr2.length; i++) {
            map.putIfAbsent(arr2[i], i);
        }

        List<Integer> ls = new ArrayList<>();
        for(int it : arr1) ls.add(it);

        for(int i = 0; i < arr1.length; i++) 

        Collections.sort(ls, (a, b)->{
            boolean aInMap = map.containsKey(a);
            boolean bInMap = map.containsKey(b);
            
            if(!aInMap && !bInMap) return a - b;
            else if (aInMap && !bInMap) return -1;
            else if (!aInMap && bInMap) return 1;   
            else return Integer.compare(map.get(a), map.get(b)); 
        });

        for(int i = 0; i < ls.size(); i++) arr1[i] = ls.get(i);
        
        return arr1;
    }
}