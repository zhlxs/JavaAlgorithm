package algorithm.linear.list;

/**
 * @author HSL
 * @date 2022-04-05 22:26
 * @desc 删除排序链表中的相同元素
 */
public class LC_83 {

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param head
     * @return
     */
    public ListNode delDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode current = head;
        while (current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    public static ListNode delDuplicates1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next = delDuplicates1(head.next);
        // 要理解相同的两个节点，最终只会返回其中的一个
        // 要理解，返回head.next其实已经去掉了相同的那个
        return head.val == head.next.val ? head.next : head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        System.out.println(head);
        System.out.println(delDuplicates1(head).toString());
    }
}
