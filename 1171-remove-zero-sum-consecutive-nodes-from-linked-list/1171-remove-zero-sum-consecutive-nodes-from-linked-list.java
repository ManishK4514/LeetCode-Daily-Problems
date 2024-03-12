/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer, ListNode> map = new HashMap<>();
        int sum = 0;
        ListNode node = head;
        map.put(sum, null);
        while(node != null) {
            sum += node.val;            
            if(map.containsKey(sum)) {
                if(sum == 0) return removeZeroSumSublists(node.next);
                map.get(sum).next = node.next;
                return removeZeroSumSublists(head);
            }
            map.put(sum, node);
            node = node.next;            
        }

        return head;
    }
}