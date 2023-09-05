/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node node = head;

        while(node != null) {
            Node curr = new Node(node.val);
            map.put(node, curr);
            node = node.next;
        }
        
        Node dummy = head;
                
        while(dummy != null) {
            node = map.get(dummy);
            node.next = dummy.next != null ? map.get(dummy.next) : null;
            node.random = dummy.random != null ? map.get(dummy.random) : null;
            dummy = dummy.next;
        }

        return map.get(head);
    }
}