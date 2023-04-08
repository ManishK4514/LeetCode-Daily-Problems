/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;

        HashMap<Node, Node> map = new HashMap<>();
        Node clone = new Node(node.val);
        map.put(node, clone);

        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()){
            Node curr = q.remove();
            for(Node it : curr.neighbors){
                if(!map.containsKey(it)){
                    map.put(it, new Node(it.val, new ArrayList<>()));
                    q.add(it);
                }
                map.get(curr).neighbors.add(map.get(it));
            }
        }
        return map.get(node);
    }
}