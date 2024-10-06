/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/**
 * https://leetcode.com/problems/linked-list-cycle/
 *
 * Approach 1: Hash Table
 * TC: O(n), where n is the number of the input nodes. This is because in the worst case we may need to iterate through all the nodes in the linked list to determine if there is a cycle.
 * SC: O(n), because we are using a HashSet to store the nodes we have seen so far.
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode curr = head;
        Set<ListNode> seen = new HashSet<>();

        while (curr != null) {
            if (seen.contains(curr)) {
                return true;
            }
            seen.add(curr);
            curr = curr.next;
        }
        return false;
    }
}

/**
 * https://leetcode.com/problems/linked-list-cycle/
 *
 * Approach 2: Marking or In-place modification
 * TC: O(n), where n is the number of the input nodes. This is because in the worst case we may need to iterate through all the nodes in the linked list to determine if there is a cycle.
 * SC: O(1), because we are using a contant amount of extra space regardless of the size of the input linked list.
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        int min = -10001;

        while (head.next != null) {
            if (head.next.val == min) {
                return true;
            }
            head.val = min;
            head = head.next;
        }
        return false;
    }
}

/**
 * https://leetcode.com/problems/linked-list-cycle/
 *
 * Approach 3-1: Floyd’s Cycle Detection Algorithm (또는 토끼와 거북이 알고리즘)
 * 수학적 설명
 * - 순환의 길이를 C라고 가정합시다.
 * - slow 포인터가 순환에 진입할 때, fast 포인터는 이미 순환 내부의 어떤 지점에 있습니다.
 * - 두 포인터 간의 거리는 매 반복마다 1씩 감소합니다.
 * - 최악의 경우, fast 포인터가 slow 포인터 바로 뒤에 있다면, C-1번의 반복 후에 만나게 됩니다
 * TC: O(n), where n is the number of the nodes in the linked list. This is because in the worst case scenario, we may have to iterate through all the nodes in the linked list to determine if there is a cycle.
 * SC: O(1), because we are using a constant amount of extra space regardless of the size of the input linked list.
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}

/**
 * https://leetcode.com/problems/linked-list-cycle/
 *
 * Approach 3-2: Floyd’s Cycle Detection Algorithm (또는 토끼와 거북이 알고리즘)
 * 수학적 설명
 * - 순환의 길이를 C라고 가정합시다.
 * - slow 포인터가 순환에 진입할 때, fast 포인터는 이미 순환 내부의 어떤 지점에 있습니다.
 * - 두 포인터 간의 거리는 매 반복마다 1씩 감소합니다.
 * - 최악의 경우, fast 포인터가 slow 포인터 바로 뒤에 있다면, C-1번의 반복 후에 만나게 됩니다
 * TC: O(n), where n is the number of the nodes in the linked list. This is because in the worst case scenario, we may have to iterate through all the nodes in the linked list to determine if there is a cycle.
 * SC: O(1), because we are using a constant amount of extra space regardless of the size of the input linked list.
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
