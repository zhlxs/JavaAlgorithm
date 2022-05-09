package algorithm.linear.list;

/**
 * @author HSL
 * @date 2022-04-05 23:03
 * @desc 环形链表，tx面试会考察空间和时间复杂度
 */
public class LC_141 {

    /**
     * 时间复杂度：O(n)
     * 空间复杂度:O(1)
     *
     * @param head
     * @return
     */
    public boolean isCycleList(ListNode head) {
        if (head == null) return false;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
