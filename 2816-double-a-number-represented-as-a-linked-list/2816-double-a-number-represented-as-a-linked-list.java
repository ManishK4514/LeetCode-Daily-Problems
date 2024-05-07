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
    public ListNode reverse(ListNode head) {
        if(head.next == null || head == null) return head;
        ListNode node = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
    public ListNode doubleIt(ListNode head) {
        ListNode revHead = reverse(head);
        
        int carry = 0;
        ListNode node = revHead;
        ListNode prev = null;

        while(node != null) {
            int val = (2 * node.val) + carry;
            node.val = val % 10;
            prev = node;
            node = node.next;
            carry = val / 10;
        }

        if(carry > 0) {
            ListNode currNode = new ListNode(carry);
            prev.next = currNode;
        }

        return reverse(revHead);
    }
}