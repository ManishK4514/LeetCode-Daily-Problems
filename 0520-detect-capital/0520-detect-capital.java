class Solution {
    public boolean detectCapitalUse(String word) {
        int countUpperCase = 0;
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) >=  'A' && word.charAt(i) <= 'Z') countUpperCase++;
        }
        System.out.println(countUpperCase);
        if(word.length() == countUpperCase) return true;
        else if(countUpperCase == 0) return true;
        else if(countUpperCase == 1 && (word.charAt(0) >=  'A' && word.charAt(0) <= 'Z')) return true;
        else return false;
    }
}