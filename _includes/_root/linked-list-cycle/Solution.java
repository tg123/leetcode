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
    public boolean hasCycle(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(head == null) return false;
        
        ListNode fast = head;
        ListNode slow = head;
        
        
        while(slow.next != null){
            
            if(fast.next == null) return false;
            
            fast = fast.next.next;
            
            if(fast == null) return false;
            
            slow = slow.next;
            
            if(fast == slow) return true;
        }
        
        return false;
    }
}