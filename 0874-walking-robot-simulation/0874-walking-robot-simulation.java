class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        // dir -> 0 (North), 1 (East), 2 (South), 3 (West)
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        HashSet<String> set = new HashSet<>(); 
        for(int[] obstacle : obstacles) set.add(obstacle[0] + "#" + obstacle[1]);

        int ans = 0, x = 0, y = 0, dir = 0;

        for(int command : commands) {
            if(command == -1) dir = (dir + 1) % 4;
            else if(command == -2) dir = (dir + 3) % 4;
            else {
                for (int i = 0; i < command; i++) {
                    int newX = x + directions[dir][0];
                    int newY = y + directions[dir][1];

                    if (!set.contains(newX + "#" + newY)) {
                        x = newX;
                        y = newY;
                        ans = Math.max(ans, x * x + y * y);
                    } 
                    else break;
                }
            }
        }

        return ans;
    }
}