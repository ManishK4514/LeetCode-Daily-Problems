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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        int top = 0, right = n - 1, bottom = m - 1, left = 0, dir = 0, curr = 1;

        ListNode node = head;

        while(top <= bottom && left <= right){
            if(dir == 0){
                for(int i = left; i <= right; i++){
                    matrix[top][i] = node != null ? node.val : -1;    
                    if(node != null) node = node.next;                
                }
                top++;
            }
            else if(dir == 1){
                for(int i = top; i <= bottom; i++){
                    matrix[i][right] = node != null ? node.val : -1;    
                    if(node != null) node = node.next;  
                }
                right--; 
            }
            else if(dir == 2){
                for(int i = right; i >= left; i--){
                    matrix[bottom][i] = node != null ? node.val : -1;    
                    if(node != null) node = node.next;  
                }
                bottom--;
            }
            else{
                for(int i = bottom; i >= top; i--){
                    matrix[i][left] = node != null ? node.val : -1;    
                    if(node != null) node = node.next;  
                }
                left++; 
            }
            
            dir = (dir + 1) % 4;
        }

        return matrix;
    }
}