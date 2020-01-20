package list;

import model.ListNode;
import org.junit.Test;

import java.util.List;

/**
 * Created by johnlim on 3/2/17.
 */
public class DeleteCurrentNode {

    @Test
    public void deleteNode() {
        ListNode a = new ListNode(0);
        ListNode b = new ListNode(1);

        ListNode c = new ListNode(3);

        ListNode d = new ListNode(4);

        a.next=b;
        //b.next=c;
        //sc.next=d;

        deleteNode(a);
        a.print();

    }

    public void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;

       /* ListNode prev = null;
        while(node!=null){
            if(node.next!=null && node.next.next==null ){
                if(prev==null) {

                    prev=node;
                    node = node.next;
                    System.out.println("shit"+node.val);
                    prev.val=node.val;
                    prev.next=null; //clear the chain
                }else
                    prev.next = node.next;
            }
            prev=node;
            node=node.next;
        }*/

    }
}
