package algorithm.linear.list;

/**
 * @author HSL
 * @date 2022-04-05 21:48
 * @desc
 */
public class LC_21 {
    /**
     * 时间复杂度：O(m+n)
     * 空间复杂度：O(1)
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode res = new ListNode(0);
        ListNode p = res;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return res.next;
    }

    /**
     * 时间复杂度：O(m+n)
     * 空间复杂度：O(m+n)
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeLists1(l1.next, l2);
            return l1;
        }
        l2.next = mergeLists1(l1, l2.next);
        return l2;
    }
}
