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
    
    ListNode reverse(ListNode head){
        ListNode prev = null;
        
        while(head != null){
            ListNode t = head.next;
            
            head.next = prev;
            prev = head;
            
            head = t;
        }
        
        return prev;
    }
    
    ListNode mid(ListNode head){
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
    
    public void reorderList(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(head == null) return;
        if(head.next == null) return;

        ListNode left = head;

        ListNode mid = mid(head);

        ListNode right = mid.next;

        if(right == null) return;

        mid.next = null;

        right = reverse(right);

        while(head != null){
            ListNode t = head.next;

            ListNode r = right;

            if(r == null) return;

            head.next = r;
            right = right.next;
            r.next = t;

            head = t;
        }

    }
}