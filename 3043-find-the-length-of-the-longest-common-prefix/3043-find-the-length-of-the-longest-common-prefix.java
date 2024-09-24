class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();

        for(int x : arr1) {
            while(x > 0) {
                set.add(x);
                x = x/10;                
            }
        }

        System.out.println(set);

        int len = 0;

        for(int y : arr2) {
            while(y > 0) {
                if(set.contains(y)) len = Math.max(len, (y + "").length());
                y = y/10;            
            }
        }

        return len;
    }
}