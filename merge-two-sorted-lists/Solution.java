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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ListNode rt = new ListNode(0);
        ListNode h = rt;
        
        while( l1 != null && l2 != null){
            if(l1.val < l2.val){
                rt.next = l1;
                l1 = l1.next;
            }else{ 
                rt.next = l2;
                l2 = l2.next;
            }
            
            rt = rt.next;
        }

        if(l1 != null) rt.next = l1;
        else rt.next = l2;
        
        
        return h.next;

        
    }
}