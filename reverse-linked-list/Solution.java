/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {

        if(head == null) return null;
        if(head.next == null) return head;

        ListNode tail = head.next;
        ListNode reversed = reverseList(head.next);

        tail.next = head;

        head.next = null;

        return reversed;
    }
}
