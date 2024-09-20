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
 * https://leetcode.com/problems/reverse-linked-list/
 * Approach 1. Iterative
 * - TC: O(n), where n is the size of nodes.
 * - SC: O(n), where n is the size of nodes.
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        List<Integer> nums = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            nums.add(curr.val);
            curr = curr.next;
        }
        ListNode newHead = new ListNode(nums.get(nums.size() - 1));
        curr = newHead;
        for (int i = nums.size() - 2; i >= 0; i--) {
            newHead.next = new ListNode(nums.get(i));
            newHead = newHead.next;
        }
        return curr;
    }
}

/**
 * https://leetcode.com/problems/reverse-linked-list/
 *
 * Approach 2. Improve Iterative
 * - TC: O(n), where n is the size of nodes.
 * - SC: O(1)
 * 루프 종료 시점:
 * - 루프가 끝날 때, curr은 null이 됩니다 (원래 리스트의 끝을 지났음).
 * - 이 시점에 prev는 원래 리스트의 마지막 노드를 가리키고 있습니다.
 * 예를 들어, 1 -> 2 -> 3 -> null 리스트를 뒤집으면:
 * - 루프가 끝날 때 prev는 3을 가리킵니다.
 * - 뒤집힌 리스트는 3 -> 2 -> 1 -> null이 됩니다.
 * - 3이 새로운 헤드이므로 prev를 반환합니다.
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

/**
 * https://leetcode.com/problems/reverse-linked-list/
 *
 * Approach 2. Improve Iterative
 * - TC: O(n), where n is the size of nodes.
 * - SC: O(n), where n is the size of recursion level.
 * 예)
 * 1->2->3->4 노드로 구성된 연결 리스트를 예시로 이 재귀적 뒤집기 과정을 설명합니다.
 * 초기 상태: 1 -> 2 -> 3 -> 4 -> null
 * 1. 첫 번째 호출 (head = 1):
 * - reverseList(2)를 호출합니다.
 * 2. 두 번째 호출 (head = 2):
 * - reverseList(3)을 호출합니다.
 * 3. 세 번째 호출 (head = 3):
 * - reverseList(4)를 호출합니다.
 * 4. 네 번째 호출 (head = 4):
 * - 기저 조건에 해당 (head.next == null), 4를 반환합니다.
 * 5. 세 번째 호출로 돌아옴 (head = 3):
 * - p = 4
 * - 3.next.next = 3 (4가 3을 가리키게 함)
 * - 3.next = null
 * - 현재 상태: 1 -> 2 -> 3 <- 4
 * 6. 두 번째 호출로 돌아옴 (head = 2):
 * - p = 4
 * - 2.next.next = 2 (3이 2를 가리키게 함)
 * - 2.next = null
 * - 현재 상태: 1 -> 2 <- 3 <- 4
 * 7. 첫 번째 호출로 돌아옴 (head = 1):
 * - p = 4
 * - 1.next.next = 1 (2가 1을 가리키게 함)
 * - 1.next = null
 * - 최종 상태: 4 -> 3 -> 2 -> 1 -> null
 * 최종적으로 새로운 헤드 노드인 4를 반환합니다.
 * 각 재귀 호출에서 현재 노드와 그 다음 노드의 연결을 뒤집고, 마지막 노드(여기서는 4)가 새로운 헤드가 되어 반환됩니다.
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}

