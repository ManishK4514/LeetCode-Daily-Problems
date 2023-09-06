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
        int n = 0;
        ListNode node = head;
        while(node != null){
            n++;
            node = node.next;
        }
        int si = n % k, div = n / k;
        ListNode[] res = new ListNode[k]; 
        for(int i = 0; i < k; i++){
            int currSize = div;
            if(i < si) currSize += 1;
            
            if(currSize == 0) res[i] = null;
            else{
                int curr = 0;
                res[i] = head;
                ListNode prev = null;
                while(head != null){
                    prev = head;
                    curr++;
                    head = head.next;
                    if(curr == currSize) {
                        prev.next = null;
                        break;
                    }
                }
            }
        }
        return res;
    }
}