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
    public void reorderList(ListNode head) {
        if (head.next == null) {
            return;
        }
        List<ListNode> nodes = new ArrayList<>();
        ListNode temp = head;
        while (head != null) {
            ListNode next = head.next;
            head.next = null;
            nodes.add(head);
            head = next;
        }

        int left = 0;
        int right = nodes.size() - 1;
        while (left < right) {
            temp.next = nodes.get(right);
            right--;
            left++;
            if (left <= right && left < nodes.size()) {
                temp = temp.next;
                temp.next = nodes.get(left);
                temp = temp.next;
            }
        }
    }
}