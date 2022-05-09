package algorithm.linear.list;

/**
 * 求链表的倒数第k个节点
 * hash表求解：空间复杂度为O(n),增加了空间复杂度
 * 解法：双指针
 * 思路：倒数第k个节点，等于正数第n-k+1个节点
 * 普通思路：全部遍历，求链表长度，再次遍历，定位节点，总共遍历两次
 * 升级思路：双指针
 * 注意：考虑边界值
 */
public class Offer_22 {
    public static ListNode kthNode(ListNode head, int kthNode) {
        if (kthNode <= 0 || head == null) {
            return null;
        }
        ListNode temp = head, pkthNode = null;
        // 沿着链表移动了k-1次
        for (int count = 1; count < kthNode; count++) {
            if (temp != null) {
                temp = temp.next;
            }
        }
        while (temp != null) {
            if (pkthNode == null) {
                pkthNode = head;
            } else {
                pkthNode = pkthNode.next;
            }
            temp = temp.next;
        }
        if (pkthNode != null) {
            return pkthNode;
        }
        return null;
    }

}
