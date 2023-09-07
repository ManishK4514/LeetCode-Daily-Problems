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
    ListNode temp = null;
    public ListNode helper(int right, ListNode head){
        if(right == 1) {
            temp = head.next;
            return head;
        }
        ListNode node = helper(right - 1, head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = head;
        for(int i = 1; i <= left; i++){
            if(i == left - 1){
                ListNode temp2 = dummy.next;
                ListNode node = helper(right - left + 1, dummy.next);
                dummy.next = node;
                temp2.next = temp;
                break;
            }
            else if(i == left){
                ListNode node = helper(right - left + 1, dummy);
                head.next = temp;
                head = node;
            }
            dummy = dummy.next;
        }        
        return head;
    }
}