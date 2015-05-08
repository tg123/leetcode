/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    ListNode reverse(ListNode head) {
        
        ListNode prev = null;
        
        while(head != null){
            ListNode t = head.next;
            
            head.next = prev;
            prev = head;
            
            head = t;
        }
        
        return prev;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(k <= 1) return head;
        if(head == null) return null;
        if(head.next == null) return head;
        
        ListNode tail = head;
        
        for(int i = 1; i < k && tail != null; i++){
            tail = tail.next;
        }
        
        if (tail == null) {
            // less than k nodes
            return head;
        }
        
        
        ListNode next = tail.next;
        tail.next = null; // cut
        
        tail = head; // head will be new tail
        head = reverse(head);
        
        tail.next = reverseKGroup(next, k);
        
        return head;
    }
}
