package model;

import static java.lang.System.out;

public class ListNode{
    public ListNode next;
    public int val;
    public ListNode(int x) { val = x; }

    public static void print(ListNode ln){
        assert ln != null;
        out.print(ln.val);
        while((ln=ln.next)!=null) out.printf("->%d",ln.val);
        out.println();
    }
}
