class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> queue = new LinkedList<>();
        for(Integer num : rooms.get(0)){
            queue.add(num);
        }
        visited[0] = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int idx = queue.remove();
                if(visited[idx] == false){
                    for(Integer num : rooms.get(idx)){
                        queue.add(num);
                    }
                }
                visited[idx] = true;                
            }
        }
        for(int i = 0; i < visited.length; i++){
            if(visited[i] == false) return false;
        }
        return true;
    }
}