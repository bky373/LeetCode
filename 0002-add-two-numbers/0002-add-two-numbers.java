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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode initNode = new ListNode(-1);
        ListNode curNode = initNode;
        int temp = 0;
        int x = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                x += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                x += l2.val;
                l2 = l2.next;
            }
            x += temp;
            curNode.next = new ListNode(x % 10);
            curNode = curNode.next;
            temp = 0;
            if (x >= 10) {
                temp = 1;
            }
            x = 0;
        }
        if (temp == 1) {
            curNode.next = new ListNode(1);
        }
        return initNode.next;
    }
}