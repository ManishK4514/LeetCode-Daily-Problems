class Solution {
    public int maxChunksToSorted(int[] arr) {
        int runningSum = 0, expectedSum = 0, chunks = 0;

        for (int i = 0; i < arr.length; i++) {
            runningSum += arr[i];
            expectedSum += i;
            if (runningSum == expectedSum) chunks++;
        }

        return chunks;
    }
}