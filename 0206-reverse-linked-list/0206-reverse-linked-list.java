/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode a = new ListNode(head.val);
        ListNode b;
        while (head.next != null) {
            b = new ListNode(head.next.val, a);
            a = b;
            head = head.next;
        }
        return a;
    }
}