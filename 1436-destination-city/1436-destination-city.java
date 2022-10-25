class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> set= new HashSet<>();
        for (List<String> l: paths) set.add(l.get(1));
        for (List<String> l: paths) set.remove(l.get(0));
        return set.iterator().next();
    }
}