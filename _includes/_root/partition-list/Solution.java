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
    public ListNode partition(ListNode head, int x) {
        if(head == null) return null;
        if(head.next == null) return head;
        
        final ListNode less = new ListNode(0);
        final ListNode greater = new ListNode(0);
        
        ListNode _less    = less;
        ListNode _greater = greater;
        
        while(head != null){
            ListNode t = head;
            head = head.next;
            
            if(t.val < x){
                _less.next = t;
                _less = _less.next;
            }else {
                _greater.next = t;
                _greater = _greater.next;
            }
        }
        
        _greater.next = null;
        
        _less.next  = greater.next;
        
        return less.next;
        
    }
}
