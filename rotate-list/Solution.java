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
    public ListNode rotateRight(ListNode head, int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        if(head == null) return null;
        
        ListNode _head = head;
        
        ListNode node = head;
        int len = 1;
        while(node.next != null){
            len++;
            node = node.next;
        }
        
        n %= len;

        ListNode tail = node;
        
        node = head;
        for(int i = 0; i < len - n - 1; i++) node = node.next;
        
        tail.next = head;
        ListNode rt = node.next;
        node.next = null;
        
        return rt;
        
    }
}