package algorithm.linear.list;

/**
 * 反转链表
 * 热度：★★★★
 */
public class LC_206 {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;

            pre = curr;
            curr = next;
        }
        return pre;
    }
}
