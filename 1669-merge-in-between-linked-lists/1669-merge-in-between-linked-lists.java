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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode tail = list2;
        while(tail.next != null) tail = tail.next;
        
        ListNode prev = null;
        ListNode node = list1;

        int idx = 0;
        
        while(node != null) {
            if(idx == b) {
                prev.next = list2;
                tail.next = node.next;
            }
            
            if(idx < a) prev = node;
            idx++;
            node = node.next;
        }

        return list1;
    }
}