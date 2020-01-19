package list;

import model.ListNode;

public class MergeSortedList {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode head = res;
        while(l1!=null && l2!=null){
            if(l1.val < l2.val){
                res.next = l1;
                res= res.next;
                l1 = l1.next;
            }else{
                res.next = l2;
                res= res.next;
                l2 = l2.next;
            }
        }
        if(l1!=null){
            res.next = l1;
        }
        if(l2!=null){
            res.next = l2;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.add(new ListNode(2));
        a.add(new ListNode(4));

        ListNode b = new ListNode(1);
        b.add(new ListNode(3));
        b.add(new ListNode(4));

        mergeTwoLists(a,b).print();
    }
}
