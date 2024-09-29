class AllOne {
    private Map<String, Integer> count;
    private TreeSet<Pair<Integer, String>> set;

    public AllOne() {
        count = new HashMap<>();
        set = new TreeSet<>((a, b) -> {
            int keyComparison = b.getKey().compareTo(a.getKey());
            if (keyComparison != 0) {
                return keyComparison; 
            }
            return a.getValue().compareTo(b.getValue()); 
        });
    }

    public void inc(String key) {
        int n = count.getOrDefault(key, 0);
        count.put(key, n + 1);
        set.remove(new Pair<>(n, key));
        set.add(new Pair<>(n + 1, key));
    }

    public void dec(String key) {
        int n = count.get(key);
        set.remove(new Pair<>(n, key));
        if (n == 1)
            count.remove(key);
        else {
            count.put(key, n - 1);
            set.add(new Pair<>(n - 1, key));
        }
    }

    public String getMaxKey() {
        return set.isEmpty() ? "" : set.first().getValue();
    }

    public String getMinKey() {
        return set.isEmpty() ? "" : set.last().getValue();
    }
}