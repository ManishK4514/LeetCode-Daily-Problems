class Solution {
    private String getCoordinates(int x, int y) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(x);
        stringBuilder.append("#");
        stringBuilder.append(y);
        return stringBuilder.toString();
    }
    public boolean isPathCrossing(String path) {
        int x = 0, y = 0, n = path.length();
        HashSet<String> set = new HashSet<>();
        set.add(x + "#" + y);
        
        for(char c : path.toCharArray()) {
            switch (c) {
                case 'N':
                    y++;
                    break;
                case 'E':
                    x++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'W':
                    x--;
                    break; 
            } 

            String coordinates = getCoordinates(x, y);
            if (set.contains(coordinates)) {
                return true;
            }
            set.add(coordinates);
        }
        
        return false;
    }
}