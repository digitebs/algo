package list;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertTrue;

/**
 * Created by johnlim on 13/1/17.
 */
public class CrackCodeLinkedList {

    class LinkListNode{
        LinkListNode next;
        int value;

        public LinkListNode(int value) {
            this.value = value;
        }
    }

    @Test
    public void listSum(){


        LinkListNode node1 = new LinkListNode(7);
        node1.next = new LinkListNode(1);
        node1.next.next = new LinkListNode(6);
        node1.next.next.next = new LinkListNode(5);

        LinkListNode node2 = new LinkListNode(5);
        node2.next = new LinkListNode(9);
        node2.next.next = new LinkListNode(2);
        listSum(node1,node2,0);
    }
    private void listSum(LinkListNode node1, LinkListNode node2,int carry){
       if(node1==null && node2==null && carry==0)
           return;

        int val =(node1==null)?0:node1.value + ((node2==null)?0:node2.value) +carry;
       System.out.print(val%10);

        if(node1==null || node2==null)
            return;

       listSum(node1.next, node2.next,val/10);
    }

    @Test
    public void deleteDup(){
        LinkListNode node = new LinkListNode(10);
        node.next = new LinkListNode(10);
        node.next.next = new LinkListNode(5);
        node.next.next.next = new LinkListNode(8);
        deleteDup(node);
    }

    @Test
    public void kth(){
        LinkListNode node = new LinkListNode(10);
        node.next = new LinkListNode(10);
        node.next.next = new LinkListNode(5);
        node.next.next.next = new LinkListNode(8);
        kth(node,2,4);
    }



    private void kth(LinkListNode node, int k,int size){
        int index = size-k;
        for (int j = 0; j < index; j++) {
            node =node.next;
        }

        System.out.println(node.value);


    }
    private void printNode(LinkListNode node){
        while(node !=null){
            System.out.print(node.value+ "->");
            node= node.next;
        }
    }

    private void deleteDup(LinkListNode node){

        HashSet set = new HashSet();
        LinkListNode previous=null;
        LinkListNode firstNode=node;
        while(node!=null){

            if(set.contains(node.value)){
                previous.next = node.next;
            }else {
                set.add(node.value);
               // if(previous==null)
                previous = node;
            }
            node= node.next;
        }

        printNode(firstNode);

    }
}
