class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = head;
        ListNode newHead = new ListNode(-1);
        ListNode node = newHead;
        dummy = dummy.next;

        while(dummy != null) {
            int sum = 0;            
            while(dummy.val != 0) {
                sum += dummy.val;
                dummy = dummy.next;
            }
            ListNode curr = new ListNode(sum);
            node.next = curr;
            node = node.next;
            dummy = dummy.next;
        }

        return newHead.next;
    }
}
