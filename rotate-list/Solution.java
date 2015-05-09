/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head == null) return null;
        
        int len = 1;
        
        ListNode tail = head;
        
        while(tail.next != null){
            len++;
            tail = tail.next;
        }
        
        tail.next = head; // cycle
        
        k %= len;
        
        for(int i = 1; i < len - k; i++){
            head = head.next;
        }
        
        try {
            return head.next;
        } finally {
            head.next = null; // cut
        }
        
    }
}
