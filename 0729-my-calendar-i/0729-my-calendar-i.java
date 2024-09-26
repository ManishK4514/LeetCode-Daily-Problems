class MyCalendar {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    public MyCalendar() {
        map.put(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }
    
    public boolean book(int start, int end) {
        var e = map.higherEntry(start);
        if(end <= e.getValue()){
            map.put(end, start);
            return true;
        }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */