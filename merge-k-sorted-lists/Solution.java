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
    
    ListNode merge(ListNode l1, ListNode l2){
        ListNode m = new ListNode(0);
        ListNode h = m;
        
        while(l1 != null && l2 != null){
            
            if(l1.val < l2.val){
                m.next = l1;
                l1 = l1.next;
            }else{
                m.next = l2;
                l2 = l2.next;
            }
            
            m = m.next;
        }
        
        if(l1 == null) m.next = l2;
        else m.next = l1;
        
        return h.next;
    }
    
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        if(lists == null) return null;
        
        LinkedList<ListNode> s = new LinkedList<ListNode>(lists);
        
        while(s.size() > 1){
            s.push(merge(s.pop(), s.pop()));
        }
        
        if(s.size() == 1) return s.get(0);
        
        return null;
        
    }
}