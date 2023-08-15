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
    public ListNode partition(ListNode head, int x) {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(0);

        ListNode p1 = node1, p2 = node2, node = head;

        while(node != null) {
            if(node.val < x) {
                p1.next = node;
                p1 = p1.next;
            }
            else {
                p2.next = node;
                p2 = p2.next;
            }
            node = node.next;
        }

        p1.next = node2.next;
        if(p2 != null) p2.next = null;

        return node1.next;
    }
}