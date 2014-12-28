/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        
        
        if (head == null) return null;
        
        if (head.next == null) return head;
        
        ListNode newhead = head.next;
        head.next = swapPairs(head.next.next);
        
        newhead.next = head;
        
        return newhead;
        
    }
}