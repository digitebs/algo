package list;

import model.ListNode;

public class LinkedListDeleteDuplicatesSorted {

    static ListNode deleteDuplicates(ListNode a) {
        ListNode current=a;
        while(a!=null){
            while(a.next!=null && a.val == a.next.val){ // if next value is the same
                a.next = a.next.next; //point current to next next
            }
            a = a.next;
        }
        return current;
    }

    static void printNode(ListNode n){

        while(n!=null){
            System.out.print(n.val + "->");
            n = n.next;
        }

    }

    public static void main(String[] args) {
        ListNode ln4 = new ListNode(3);

        ListNode ln3 = new ListNode(2);
        ln3.next =ln4;


        ListNode ln2 = new ListNode(1);
        ln2.next =ln3;

        ListNode ln1 = new ListNode(1);
        ln1.next =ln2;

        ListNode res = deleteDuplicates(ln1);
        printNode(res);
    }

}
