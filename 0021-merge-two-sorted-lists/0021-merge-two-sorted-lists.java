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

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * Approach 1: Iteration
 * - TC: O(m + n), where m and n are the lengths of two input lists. This is because we iterate through both lists once to merge them together.
 * - SC: O(1), because we only use a constant amount of extra space for the pointers and variables, regardless of the input sizes.
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode first = list1;
        ListNode second = list2;
        ListNode curr = null;
        if (first.val <= second.val) {
            curr = first;
            first = first.next;
        } else {
            curr = second;
            second = second.next;
        }
        ListNode result = curr;
        while (first != null && second != null) {
            if (first.val <= second.val) {
                curr.next = first;
                first = first.next;
            } else {
                curr.next = second;
                second = second.next;
            }
            curr = curr.next;
        }

        if (first == null) {
            curr.next = second;
        } else {
            curr.next = first;
        }

        return result;
    }
}

/**
 * Approach 2: Iteration Improved
 * - TC: O(m + n), where m and n are the lengths of the two input lists. This is because we iterate through both lists to merge them together.
 * - SC: O(1), because we use a constant amount of extra space for the pointers and varibles regardless of the input sizes.
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }

        if (list1 == null) {
            prev.next = list2;
        } else {
            prev.next = list1;
        }

        return prehead.next;
    }
}


/**
 * Approach 3: Recursion
 * TC: O(m + n), Because each recursive call increments the pointer to l1 or l2 by one (approaching the dangling null at the end of each list), there will be exactly one call to mergeTwoLists per element in each list. Therefore, the time complexity is linear in the combined size of the lists.
 * SC: O(m + n), The first call to mergeTwoLists does not return until the ends of both l1 and l2 have been reached, so n+m stack frames consume O(n+m) space.
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
