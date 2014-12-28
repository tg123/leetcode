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
    public ListNode reverseKGroup(ListNode head, int k) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if(k <= 1) return head;
        
        if(head == null) return null;
        if(head.next == null) return head;
        
        ListNode tail = head;
        ListNode prev = null;
        
        for(int i = 0; i < k ; i++){
            if(head == null){
                
                // rollback
                head = prev;
                prev = null;
                
                while(head != null){
                    ListNode t = head.next;
                    
                    head.next = prev;
                    prev = head;
                    
                    head = t;
                }
                
                return prev;
            }
            
            ListNode t = head.next;
             
            head.next = prev;
            prev = head;
             
            head = t;
        }
        
        tail.next = reverseKGroup(head, k);
        
        return prev;
        
    }
}