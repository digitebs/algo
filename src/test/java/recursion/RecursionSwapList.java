package recursion;

import model.ListNode;

public class RecursionSwapList {
        public void swap(ListNode head) {
            if(head.next == null || head.next.next == null) return;
            ListNode skip2 = head.next.next;
            ListNode skip1 = head.next;
            head.next = skip2;
            skip1.next = skip2.next;
            skip2.next = skip1;
            swap(skip1);
        }
        public ListNode swapPairs(ListNode head) {
            ListNode root = new ListNode(0);
            root.next = head;
            swap(root);
            return root.next;
        }

    public static void main(String[] args) {
        ListNode ln1 = new ListNode(10);
        ListNode ln2 = new ListNode(20);
        ListNode ln3 = new ListNode(30);
        ListNode ln4 = new ListNode(40);

        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ListNode r = new RecursionSwapList().swapPairs(ln1);
        r.print();
    }
}
