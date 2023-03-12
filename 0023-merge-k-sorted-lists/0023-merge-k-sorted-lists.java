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
    public ListNode merge2Lists(ListNode l1, ListNode l2){
        ListNode head = new ListNode();
        ListNode dummy = head;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                dummy.next = l1;
                dummy = dummy.next;
                l1 = l1.next;
            }
            else{
                dummy.next = l2;
                dummy = dummy.next;
                l2 = l2.next;
            }
        }
        if(l1 == null) dummy.next = l2;
        else dummy.next = l1;

        return head.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
       ListNode prev = null;
       for(int i = 0; i < lists.length; i++){
           prev = merge2Lists(prev, lists[i]);
       }
       return prev;
    }
}