/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    ListNode mid(ListNode head){

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    ListNode reverse(ListNode head) {
        ListNode prev = null;

        while(head != null){

            ListNode t = head.next;

            head.next = prev;
            prev = head;

            head = t;
        }

        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode m = mid(head);

        m = reverse(m);

        while(m != head && m != null){

            if(m.val != head.val){
                return false;
            }

            m = m.next;
            head = head.next;
        }

        return true;
    }
}
