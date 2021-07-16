package queue;

import java.util.PriorityQueue;
import model.ListNode;

public class MergeKSortedList {
  public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->{
      return a.val - b.val;
    });
    for(int i =0; i < lists.length;i++){
      if(lists[i]!=null) pq.add(lists[i]);
    }

    ListNode head = null,curr=null;
    while(!pq.isEmpty()){
      ListNode temp = pq.poll();
      if(curr == null)
        head = curr = temp;
      else
        curr = curr.next = temp;

      if(temp.next !=null)
        pq.offer(temp.next);
    }
    return head;
  }

  public static void main(String[] args) {
    MergeKSortedList mergeKSortedList = new MergeKSortedList();

    ListNode[] ln= new ListNode[3];
    ln[0] = new ListNode(1);
    ln[0].next = new ListNode(4);
    ln[0].next.next = new ListNode(5);

    ln[1] = new ListNode(1);
    ln[1].next = new ListNode(3);
    ln[1].next.next = new ListNode(4);

    ln[2] = new ListNode(2);
    ln[2].next = new ListNode(6);

    ListNode result = mergeKSortedList.mergeKLists(ln);
    result.print();
  }
}
