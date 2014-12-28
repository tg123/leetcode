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
    
    ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
    
    public ListNode mergeKLists(List<ListNode> lists) {
        
        final int size = lists.size();
        
        if(size == 0) return null;
        if(size == 1) return lists.get(0);
        if(size == 2) return mergeTwoLists(lists.get(0), lists.get(1));
        
        return mergeTwoLists(mergeKLists(lists.subList(0, size / 2)), mergeKLists(lists.subList(size / 2, size)));
    }
}
