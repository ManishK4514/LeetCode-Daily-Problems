class RandomizedSet {
    HashMap<Integer, Integer> map = new HashMap<>();
    ArrayList<Integer> arr = new ArrayList<>();
    public RandomizedSet() {
        
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        else{
            arr.add(val);
            map.put(val, arr.size() - 1);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if(map.containsKey(val)){
            int index = map.get(val);
            // Last Element
            int v = arr.get(arr.size() - 1);
            arr.set(index, v);
            arr.remove(arr.size() - 1);
            // Updating index in the map
            map.put(v, index);
            map.remove(val);
            return true;
        }
        else return false;
    }
    public int getRandom() {
        int min = 1;
        int max = 1000;
        int index = (int)(Math.random() * (max - min + 1) + min) % arr.size();
        return arr.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */