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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        ListNode resultHead = head;
        List<ListNode> nodes = new ArrayList<>();
        while (head != null) {
            nodes.add(head);
            head = head.next;
        }
        int i = nodes.size() - n;
        if (i <= 0) {
            return resultHead.next;
        }
        ListNode node = nodes.get(i - 1);
        if (node.next != null) {
            node.next = node.next.next;
        } else {
            node.next = null;
        }
        return resultHead;
    }
}