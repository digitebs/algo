package list;

import model.ListNode;

public class LinkedListRemoveFromEnd {
    private ListNode removeNthFromEnd(ListNode a, int b) {
        ListNode start = a; //store a pointer ok????
        //lets count the list size coz  no additional space is allowed;
        int count =0;
        while(a!=null){
            count++; // lets bulk up
            a= a.next;
        }
        int delIndex = count-b;
        if(delIndex <= 0)
            start = start.next; //just simple move the pointer
        else{
            a = start;
            ListNode previous = null;
            for(int i=0; i< delIndex; i++){
                previous = a;
                a = a.next;
            }
            previous.next = a.next;
        }
        return start;
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
        new LinkedListRemoveFromEnd().removeNthFromEnd(ln1,2);
    }
}
