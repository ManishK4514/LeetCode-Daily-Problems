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
    public int gcd(int a, int b) {
        if (b != 0) return gcd(b, a % b);           
        else return a;            
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode node = head;
        ListNode prev = null;

        while(node != null) {
            if(prev != null) {
                int currGcd = gcd(prev.val, node.val);
                ListNode newNode = new ListNode(currGcd);
                prev.next = newNode;
                newNode.next = node;
            }

            prev = node;
            node = node.next;
        }

        return head;
    }
}