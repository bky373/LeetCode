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
    public ListNode middleNode(ListNode head) {
        int size = 0;
        ListNode currNode = head;
        while (currNode != null) {
            size++;
            currNode = currNode.next;
        }
        int middleIdx = size / 2;
        currNode = head;
        for (int i = 0; i < middleIdx; i++) {
            currNode = currNode.next;
        }
        return currNode;    
    }
}