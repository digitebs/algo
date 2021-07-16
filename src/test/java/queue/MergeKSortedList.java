package queue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import model.ListNode;

public class MergeKSortedList {

  public ListNode merge(ListNode a, ListNode b) {
    ListNode head = new ListNode(-1); // dummy
    ListNode curr = head;
    while (a != null && b != null) {
      if (a.val < b.val) {
        curr.next = a;
        a = a.next;
      } else {
        curr.next = b;
        b = b.next;
      }
      curr = curr.next;
    }

    while (a != null) {
      curr.next = a;
      a = a.next;
      curr = curr.next;
    }

    while (b != null) {
      curr.next = b;
      b = b.next;
      curr = curr.next;
    }

    return head.next;
  }

  public ListNode mergeKLists2(ListNode[] lists) {
    int n = lists.length;
    if (n == 1) return lists[0];

    ListNode[] temp = new ListNode[n / 2 + n % 2];
    for (int i = 0, j = 0; i < n; i += 2, j++)
      temp[j] = (i == n - 1) ? lists[i] : merge(lists[i], lists[i + 1]);

    return mergeKLists2(temp);
  }

  public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListNode> pq =
        new PriorityQueue<>(
            (a, b) -> {
              return a.val - b.val;
            });
    for (int i = 0; i < lists.length; i++) {
      if (lists[i] != null) pq.add(lists[i]);
    }

    ListNode head = null, curr = null;
    while (!pq.isEmpty()) {
      ListNode temp = pq.poll();
      if (curr == null) head = curr = temp;
      else curr = curr.next = temp;

      if (temp.next != null) pq.offer(temp.next);
    }
    return head;
  }

  public static void main(String[] args) {
    MergeKSortedList mergeKSortedList = new MergeKSortedList();

    ListNode[] ln = new ListNode[4];
    ln[0] = new ListNode(1);
    ln[0].next = new ListNode(4);
    ln[0].next.next = new ListNode(5);

    ln[1] = new ListNode(7);
    ln[1].next = new ListNode(8);

    ln[2] = new ListNode(1);
    ln[2].next = new ListNode(3);
    ln[2].next.next = new ListNode(4);

    ln[3] = new ListNode(2);
    ln[3].next = new ListNode(6);

    // ln[4] = new ListNode(7);
    // ln[4].next = new ListNode(11);

    ListNode result = mergeKSortedList.mergeKLists2(ln);
    result.print();
  }
}
