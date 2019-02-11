package list;

import model.ListNode;

public class LinkedListDetectCycle {

    static ListNode detectCycle(ListNode a) {

        ListNode fast = a;
        ListNode slow = a;
        boolean hasCycle = false;
        while(fast != null && fast.next != null && slow != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                hasCycle = true;
                break;
            }
        }
        if(!hasCycle) return null;
        else{
            fast = a;
            while(fast != slow){
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }

    }

    public static void main(String[] args) {
        ListNode ln3 = new ListNode(3);

        ListNode ln2 = new ListNode(2);
        ln2.next =ln3;

        ListNode ln1 = new ListNode(1);
        ln1.next =ln2;

        ln3.next=ln2; // cycle here


        ListNode res = detectCycle(ln1);
        System.out.println(res == null? null : res.val);
    }
}
