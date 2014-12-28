/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if(head == null) return null;
        
        ListNode fast = head;
        ListNode slow = head;
        
        boolean meet = false;
        
        int lenc = 0;
        
        while ( slow.next != null){
            
            slow = slow.next;
            
            if(slow == null) return null;
            
            if(fast.next == null) return null;
            
            fast = fast.next.next;
            
            if(fast == null) return null;
            
            if(slow == fast) {
                
                if(meet) break;
                
                meet = true;
            }
            
            if(meet){
                lenc++;
            }
        }
        
        if(meet){
            
            slow = head;
            fast = head;
            for(int i = 0; i< lenc; i++){
                fast = fast.next;
            }
            
            while(slow != fast){
                slow = slow.next;
                fast = fast.next;
            }
            
            
            return slow;
            
        }
        
        return null;
    }
}