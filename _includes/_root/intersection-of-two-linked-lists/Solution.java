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

  int len(ListNode head){

    int len = 0;
    ListNode iter = head;

    while(iter != null){

      len++;
      iter = iter.next;
    }

    return len;
  }

  ListNode trim(ListNode head, int count){

    ListNode iter = head;

    while(iter != null && count > 0){

      count--;
      iter = iter.next;
    }

    return iter;
  }


  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {


    int lenA = len(headA);
    int lenB = len(headB);
    int min  = Math.min(lenA, lenB);

    ListNode iterA = trim(headA, lenA - min);
    ListNode iterB = trim(headB, lenB - min);

    ListNode intersection = null;


    while(iterA != null && iterB != null){

      if(iterA.val != iterB.val){
        intersection = null;
      } else if (intersection == null){
        intersection = iterA;
      }

      iterA = iterA.next;
      iterB = iterB.next;
    }


    if (iterA != null || iterB != null){
      return null;
    }

    return intersection;
  }
}
