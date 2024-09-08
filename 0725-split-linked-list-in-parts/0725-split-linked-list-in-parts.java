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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = 0;
        ListNode node = head;
        while(node != null) {
            len++;
            node = node.next;
        }

        int part = len / k;
        int rem = len % k;
        int i = 0, j = 0;
        node = head;
        ListNode prev = null;

        ListNode[] ans = new ListNode[k];
        int currPart = part;

        while(node != null) {    
            if((currPart == 0 && rem > 0) || i % currPart == 0) { 
                if(rem-- > 0) currPart = part + 1;
                else currPart = part;

                i = 0;
                if(prev != null) prev.next = null;
                ans[j++] = node;
            }
            prev = node;
            node = node.next;
            i++;            
        }
        
        return ans;
    }
}