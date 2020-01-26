package list;

import model.ListNode;

public class RemoveFromEnd {
    private ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head; //store a pointer ok????
        //lets count the list size coz  no additional space is allowed;
        int count =0;
        while(curr!=null){
            count++; // lets bulk up
            curr= curr.next;
        }
        int d = count-n;
        if(d <= 0)
            head = head.next; //just simple move the pointer
        else{
            curr = head;
            ListNode previous = null;
            for(int i=0; i< d; i++){
                previous = curr;
                curr = curr.next;
            }
            previous.next = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        ListNode ln5 = new ListNode(5);
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;
        new RemoveFromEnd().removeNthFromEnd(ln1,2);
    }
}
