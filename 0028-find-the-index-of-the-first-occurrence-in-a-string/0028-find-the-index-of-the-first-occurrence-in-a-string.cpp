class Solution {
public:
    int strStr(string haystack, string needle) {
        int n = haystack.length(), m = needle.length();
        if (m > n) return -1;
        int j = m - 1, i = 0;
        while (j < n) {
            if (haystack.substr(i, j - i + 1) == needle) return i;
            j++; i++;
        }
        return -1;
    }
};