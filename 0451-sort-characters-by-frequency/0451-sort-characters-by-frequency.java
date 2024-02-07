class Pair {
    char ch;
    int freq;
    Pair(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}
class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int n = map.size();
        Pair[] arr = new Pair[n];
        int idx = 0;
        for(char key : map.keySet()) {
            arr[idx++] = new Pair(key, map.get(key));
        }

        Arrays.sort(arr, (a, b)->{
            return b.freq - a.freq;
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < arr[i].freq; j++) {
                sb.append(arr[i].ch);
            }
        }

        return sb.toString();
    }
}