class Solution {
    public int search(int l, int r, int[] stack, int[] obstacles, int i){
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (stack[mid] <= obstacles[i]) l = mid + 1;
            else r = mid;
        }
        return r;
    }

    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int[] stack = new int[obstacles.length];
        int top = -1;
        int[] res = new int[obstacles.length];
        for (int i = 0; i < obstacles.length; i++) {
            if (top == -1 || obstacles[i] >= stack[top]) {
                stack[++top] = obstacles[i];
                res[i] = top + 1;
            } 
            else {              
                int idx = search(0, top, stack, obstacles, i);
                stack[idx] = obstacles[i];
                res[i] = idx + 1;
            }
            // System.out.println(Arrays.toString(stack));
        }
        return res;
    }
}