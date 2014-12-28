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
    public ListNode deleteDuplicates(ListNode head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        if(head == null) return null;
        if(head.next == null) return head;
        
        int v = head.val;
        
        ListNode node = head;
        
        boolean killme = false;
        while(node.next != null && node.next.val == v){
            node = node.next;
            killme = true;
        }
        
        if(killme)
            head = deleteDuplicates(node.next);
        else
            head.next = deleteDuplicates(node.next);
            
        return head;
        
    }
}