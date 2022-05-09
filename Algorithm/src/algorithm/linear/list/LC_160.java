package algorithm.linear.list;

/**
 * 相交链表
 */
public class LC_160 {

    /**
     * 要求：
     * 空间复杂度：O(1)
     * 时间复杂度：O(N)
     */
    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        if (a == null || b == null)
            return null;
        ListNode pA = a, pB = b;
        while (pA != pB) {
            pA = pA == null ? b : pA.next;
            pB = pB == null ? a : pB.next;
        }
        return pA;
    }

    /**
     * 改进版
     *
     * @param a
     * @param b
     * @return
     */
    public ListNode getIntersectionNode1(ListNode a, ListNode b) {
        int l1 = 0, l2 = 0, diff = 0;
        ListNode h1 = a, h2 = b;
        while (h1 != null) {
            l1++;
            h1 = h1.next;
        }
        while (h2 != null) {
            l2++;
            h2 = h2.next;
        }
        if (l1 < l2) {
            h1 = b;
            h2 = a;
            diff = l2 - l1;
        } else {
            h1 = a;
            h2 = b;
            diff = l1 - l2;
        }
        for (int i = 0; i < diff; i++) {
            h1 = h1.next;
        }
        while (h1 != null && h2 != null) {
            if (h1 == h2) {
                return h1;
            }
            h1 = h1.next;
            h2 = h2.next;
        }
        return null;
    }
}
