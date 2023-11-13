class Solution {
    private boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) != -1;
    }
    public String sortVowels(String s) {
        char[] ch = s.toCharArray();
        ArrayList<Character> vowels = new ArrayList<>();
        for(char c : ch){
            if(isVowel(c)){
                vowels.add(c);
            }
        }
        Collections.sort(vowels);
        int idx = 0;
        for(int i = 0; i < ch.length; i++){
            if(isVowel(ch[i])){
                ch[i] = vowels.get(idx++);
            }
        }
        return new String(ch);
    }
}