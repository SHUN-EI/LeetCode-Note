import java.util.List;

/**
 * Created by mo on 2020/11/21
 * 题目148：给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * <p>
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * <p>
 * 链表中节点的数目在范围 [0, 5 * 10^4] 内
 * -10^5 <= Node.val <= 10^5
 */
public class SortList {

    /**
     * 1：归并排序的整体思想
     * 2：找到一个链表的中间节点的方法
     * 3：合并两个已排好序的链表为一个新的有序链表
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        //慢指针
        ListNode slow = head;
        //快指针
        ListNode fast = head.next;

        //快慢指针找到链表中点
        while (fast != null && fast.next != null) {
            slow = slow.next;//慢指针走一步
            fast = fast.next.next;//快指针走两步
        }

        //链表第二部分的头节点
        ListNode rightHead = slow.next;
        //cut链表
        slow.next = null;

        //递归排序前一段链表
        ListNode left = sortList(head);
        //递归排序后一段链表
        ListNode right = sortList(rightHead);

        return merge(left, right);
    }

    /**
     * 合并两个有序链表
     *
     * @param n1
     * @param n2
     * @return
     */
    public ListNode merge(ListNode n1, ListNode n2) {
        ListNode temp = new ListNode(-1);
        ListNode node = temp;
        while (n1 != null && n2 != null) {
            if (n1.val < n2.val) {
                node.next = n1;
                n1 = n1.next;
            } else {
                node.next = n2;
                n2 = n2.next;
            }
            node = node.next;
        }

        if (n1 != null) {
            node.next = n1;
        } else if (n2 != null) {
            node.next = n2;
        }

        return temp.next;
    }
}
