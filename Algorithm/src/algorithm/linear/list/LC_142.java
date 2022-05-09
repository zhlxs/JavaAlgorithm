package algorithm.linear.list;

/**
 * @author HSL
 * @date 2022-04-05 23:25
 * @desc 环形链表2，返回头节点
 */
public class LC_142 {
    public ListNode isCycleList(ListNode head) {
        if (head == null) return null;
        boolean flag = false;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                flag = true;
                break;
            }
        }
        if (flag) {
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
        return null;
    }
}
