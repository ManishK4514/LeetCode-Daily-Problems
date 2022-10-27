class Solution {
    public int countVowels(String str, HashSet<Character> set){
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if(set.contains(str.charAt(i))){
                count++;
            }
        }
        return count;
    }
    public boolean halvesAreAlike(String s) {
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        String a = s.substring(0, s.length()/2);
        String b = s.substring(s.length()/2, s.length());
        int left = countVowels(a, set);
        int right = countVowels(b, set);
        if(left == right){
            return true;
        }
        return false;
    }
}