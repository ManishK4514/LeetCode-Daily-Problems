class Solution {
    public boolean halvesAreAlike(String s) {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        int count = 0, i = 0, j = s.length() - 1;

        while (i < j) {
            if (set.contains(s.charAt(i++))) ++count;
            if (set.contains(s.charAt(j--))) --count;
        }
        return count == 0;
    }
}
