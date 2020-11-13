import java.util.List;

/**
 * Created by mo on 2020/11/13
 * 题目328：给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
 * 请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * <p>
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数
 * 说明：应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推
 * <p>
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 */
public class OddEvenList {
    public ListNode oddEvenList(ListNode node) {
        //链表为空则返回null
        if (node == null) {
            return null;
        }

        //定义偶数链表的起始节点
        ListNode next = node.next;
        //odd为奇数的起始节点
        ListNode odd = node;
        //even为偶数链表的起始节点
        ListNode even = next;
        while (even != null && even.next != null) {
            //奇数链表的下一个节点为原来链表的偶数位置的下一个节点
            odd.next = even.next;
            //奇数链表赋值
            odd = odd.next;
            //偶数链表的下一个节点为原来链表的奇数位置的下一个节点
            even.next = odd.next;
            //偶数链表赋值
            even = even.next;
        }
        //奇数链表与偶数链表拼接
        odd.next = next;

        return node;
    }

}
