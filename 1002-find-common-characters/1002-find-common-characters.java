class Solution {
    public List<String> commonChars(String[] words) {
        int[] freq = new int[26];
        Arrays.fill(freq, 100);

        for(String word : words) {
            int[] currFreq = new int[26];
            for(int i = 0; i < word.length(); i++) {
                currFreq[word.charAt(i) - 'a']++;
            }
            for(int i = 0; i < 26; i++) freq[i] = Math.min(freq[i], currFreq[i]);
        }

        List<String> ans = new LinkedList<>();

        for(int i = 0; i < 26; i++) {
            while(freq[i]-- > 0) {
                ans.add(((char)(i + 97)) + "");
            }
        }

        return ans;
    }
}