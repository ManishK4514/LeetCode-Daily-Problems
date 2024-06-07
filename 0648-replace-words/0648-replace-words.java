class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");

        HashSet<String> set = new HashSet<>();
        for(String word : dictionary) set.add(word);

        for(int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder();
            String word = words[i];
            for(int j = 0; j < word.length(); j++) {
                sb.append(word.charAt(j));
                if(set.contains(sb.toString())) {
                    words[i] = sb.toString();
                    break;
                }
            }
        }

        return String.join(" ", words);
    }
}