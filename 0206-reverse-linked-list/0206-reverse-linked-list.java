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
    public ListNode helper(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode node = helper(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
    public ListNode reverseList(ListNode head) {
        return helper(head);
    }
}