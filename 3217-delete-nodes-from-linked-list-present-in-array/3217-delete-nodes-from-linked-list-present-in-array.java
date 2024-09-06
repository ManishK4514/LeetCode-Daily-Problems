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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);

        ListNode node = head;
        ListNode prev = null;

        while(node != null) {
            if(set.contains(node.val)) {
                if(prev == null) head = node.next;
                else prev.next = node.next;
            }
            else prev = node;      
            node = node.next;   
        }

        return head;
    }
}