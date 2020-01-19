package list;

import model.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DetectLoop {

    public static void main(String[] args){
        ListNode node1 = new ListNode(7);
        node1.add(new ListNode(1));
        node1.add(new ListNode(1));

        //node1.next.next.next = new LinkListNode(8);
        node1.add(node1);

        System.out.println(detectLoop(node1));
    }

    private static boolean detectLoop(ListNode slow){

        //slow runner
        while(slow!=null){
            ListNode fast =slow.next;
            //fast runner
            while(fast !=null){
                if(slow.next==fast.next)
                    return true;
                fast= fast.next;
            }

            slow = slow.next;

        }

        return false;
    }
}
