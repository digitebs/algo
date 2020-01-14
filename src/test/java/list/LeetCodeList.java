package list;

import model.ListNode;
import org.junit.Test;

import java.util.List;

/**
 * Created by johnlim on 3/2/17.
 */
public class LeetCodeList {

  private ListNode getSample(){
      ListNode a = new ListNode(0);
      ListNode b = new ListNode(1);

      ListNode c = new ListNode(3);

      ListNode d = new ListNode(4);

      a.next=b;
      b.next=c;
      c.next=d;
      d.next=b;
      return  a;
  }
@Test
    public void hasCycle() {
        System.out.println(hasCycle(getSample()));
    }
    public boolean hasCycle(ListNode head) {
        while(head!=null){
            if(head.val==-1){
                return true;
            }
            head.val=-1;
            head=head.next;
        }
        return false;
    }


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
        printNode(a);

    }

    public void printNode(ListNode node) {
        while(node!=null){
            System.out.println(node.val);
            node=node.next;
        }
    }
    public void deleteNode(ListNode node) {

        ListNode prev = null;
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
        }

    }
}
