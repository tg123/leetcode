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
    public ListNode insertionSortList(ListNode head) {
        
        if(head == null) return null;
        if(head.next == null) return head;
        
        final ListNode _head = new ListNode(Integer.MIN_VALUE);
        _head.next = head;
        
        head = head.next;
        _head.next.next = null;
        
        next:
        while(head != null){
            
            ListNode taken = head;
            head = head.next;
            
            
            ListNode cur = _head.next;
            ListNode last = _head;
            
            
            while(cur != null){
                
                if(cur.val > taken.val){
                    // insert
                    last.next = taken;
                    taken.next = cur;
                    
                    continue next;
                    
                }
                
                cur  = cur.next;
                last = last.next;
            }
            
            last.next = taken;
            taken.next = null;

        }
        
        
        return _head.next;
        
    }
}