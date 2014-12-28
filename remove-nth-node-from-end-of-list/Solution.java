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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if(head == null) return null;
        
        final ListNode _head = new ListNode(0);
        _head.next = head;

        ListNode fast = _head;
        ListNode slow = _head;
        
        for(int i = 0; i< n ; i++) fast = fast.next;
        
        while(fast != null && fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        
        return _head.next;
    }
}