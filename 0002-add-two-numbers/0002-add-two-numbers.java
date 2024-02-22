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
        int[] arr = new int[200];
        int cursor = 0;
        arr[cursor++] = l1.val;
        arr[cursor++] = l2.val;

        while (l1.next != null || l2.next != null) {
            if (l1.next != null) {
                l1 = l1.next;
                arr[cursor++] = l1.val;
            } else {
                arr[cursor++] = 0;
            }
            if (l2.next != null) {
                l2 = l2.next;
                arr[cursor++] = l2.val;
            } else {
                arr[cursor++] = 0;
            }
        }
        ListNode initNode = new ListNode(0);
        ListNode curNode = initNode;
        int temp = 0;
        for (int i = 0; i < cursor; i += 2) {
            int a = arr[i];
            int b = arr[i + 1];
            int c = a + b + temp;

            temp = 0;
            curNode.next = new ListNode(c % 10);
            curNode = curNode.next;
            if (c >= 10) {
                temp = 1;
            }
        }
        if (temp == 1) {
            curNode.next = new ListNode(1);
        }
        return initNode.next;
    }   
}