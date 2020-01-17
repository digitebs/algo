package bit;

import model.ListNode;

/**
 * 1 -> 0 -> 1
 * binary value: 5
 */
public class ListToInt {
    public static int getDecimalValue(ListNode head) {
        int s = 0;
        while(head!=null){
            if(head.val == 0)
                s = s << 1; // shift 0 to the left
            else
                s = (s << 1) | 1; // shift 1 to the left
            head=head.next;
        }
        return s;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(0);
        node.next.next = new ListNode(1);

        System.out.println(getDecimalValue(node));
    }
}
