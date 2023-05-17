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
    ListNode left;
    int max = 0;
    public int helper(ListNode head){
        if(head.next == null) return head.val;
        int right = helper(head.next);
        max = Math.max(max, left.val + right);
        left = left.next;
        return head.val;
    }
    public int pairSum(ListNode head) {
        left = head;
        helper(head);
        return max;
    }
}