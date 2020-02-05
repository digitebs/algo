package list;

import model.ListNode;

/**
 * @author john.lim
 */
public class ListSum {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(7);
        node1.next = new ListNode(1);
        node1.next.next = new ListNode(6);
        node1.next.next.next = new ListNode(5);

        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(9);
        node2.next.next = new ListNode(2);
        listSum(node1, node2, 0);
    }

    static void listSum(ListNode node1, ListNode node2, int carry) {
        if (node1 == null && node2 == null && carry == 0)
            return;

        int val = (node1 == null)
                ? 0
                : node1.val + ((node2 == null) ? 0 : node2.val) + carry;
        System.out.print(val % 10);

        if (node1 == null || node2 == null)
            return;
        listSum(node1.next, node2.next, val / 10);
    }
}
