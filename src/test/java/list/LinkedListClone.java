package list;

import model.Node;

import java.util.HashMap;

/**
 *
 * clone ll with next and rand pointer
 * @author john.lim
 */
public class LinkedListClone {

    Node clone(Node e){
            HashMap<Node, Node> hm = new HashMap<>();
            Node n = e;
            if(n == null) return null;

            while(n!=null){
                hm.put(n,new Node(n.val));
                n = n.next;
            }

            n = e;
            Node res,head;
            head = res = hm.get(n);
            while(n.next!=null){
                res.next = hm.get(n.next);
                res.right = hm.get(n.right);
                res = res.next;
                n= n.next;
            }
            return head;
    }

    public static void main(String[] args){
        LinkedListClone llc = new LinkedListClone();
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        a.next = b;
        a.right = d;
        a.next.next = c;
        a.next.right = b;
        a.next.next.next = d;
        a.next.next.right = b;
        a.next.next.next.next = e;
        a.next.next.next.right = c;


        Node ans = llc.clone(a);
        System.out.println(ans.val);
        System.out.println(ans.next.val);
        System.out.println(ans.next.next.val);
        System.out.println(ans.next.next.next.val);
        System.out.println(ans.next.next.next.next.val);
        System.out.println(ans.next.next.next.right.val);
        System.out.println(ans.next.next.right.val);
        System.out.println(ans.next.right.val);
        System.out.println(ans.right.val);
    }
}
