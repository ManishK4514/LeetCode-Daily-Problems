class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] color = new int[n + 1];
        List<Integer>[] graph = new List[n+1];
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] v : dislikes){
            graph[v[0]].add(v[1]);
            graph[v[1]].add(v[0]);
        }  
        for(int i = 1; i <= n; i++){
            if(color[i] == 0){
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                while(queue.size() != 0){
                    int top = queue.remove();
                    color[i] = 1;
                    for(int neighbour : graph[top]){
                        if(color[neighbour] == color[top]) return false;
                        if(color[neighbour] == 0){
                            color[neighbour] = -color[top];
                            queue.add(neighbour);
                        }
                    }
                }
            }
        }      
        return true;
    }
}