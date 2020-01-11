package graph;

import model.Node;
import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by johnlim on 4/2/17.
 */
public class CrackCodeGraph {
    @Test
    public void stepnum() {
     StringBuilder sb = new StringBuilder();
      //  sb.insert()
     IntStream.of(1);
     ArrayList l = new ArrayList();
       System.out.println((int)4/2);
      //  Scanner s = new Scanner(System.in);

     //"aaa".in
    }

    public ArrayList<Integer> stepnum(int a, int b) {
        ArrayList<Integer> stepNum= new ArrayList<>();
        for (int i = a; i <= b; i++) {
            String str = String.valueOf(i);

            System.out.println(str);
            boolean step=true;
            for (int j = 0; j < str.length()-1; j++) {
                System.out.println(Character.getNumericValue(str.charAt(j+1))+" "+Character.getNumericValue((str.charAt(j)))+" "+
                        (Character.getNumericValue(str.charAt(j+1))-Character.getNumericValue(str.charAt(j))));
                if(Math.abs(Character.getNumericValue(str.charAt(j+1))-Character.getNumericValue(str.charAt(j)))!= 1){
                    step=false;
                    break;
                }
            }
            if(step){
                stepNum.add(i);
            }

        }
        return stepNum;
    }

    class UndirectedGraphNode {
      int label;
      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
  };

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node,UndirectedGraphNode p) {

        if(p==null) {
            p = new UndirectedGraphNode(node.label);
            p.neighbors = new ArrayList<>();
        }
        for (int i = 0; i < node.neighbors.size(); i++) {
            p.neighbors.add(cloneGraph(node.neighbors.get(i),p));
        }

        return p;
    }

         public ArrayList<ArrayList<Integer>> levelOrder(Node a) {
            // HashSet<Node> end = new HashSet<>();
             ArrayList<ArrayList<Integer>> res = new ArrayList<>();
             ArrayList<Integer> data = new ArrayList<>();
             Queue<Node> q = new LinkedList<>();
             q.add(a);
             //end.add(a);
             while (!q.isEmpty()) {
                 int ln = q.size();
                 while(ln --> 0) {
                     Node tn = q.poll();
                     if(tn == null) continue;
                     data.add(tn.val);
                     if (tn.left != null) q.add(tn.left);
                     if (tn.right != null) q.add(tn.right);
                 }
                 res.add(data);
                 data= new ArrayList<>();
             }

             return res;
         }


         @org.junit.Test
         public void levelOrder() {
             Node a = new Node(3);
             a.left = new Node(9);
             a.right = new Node(20);
             a.left.left = new Node(6);
             a.left.right = new Node(8);
             a.left.left.right = new Node(9);
             //a.right.left = new Node(15);
             //a.right.right = new Node(7);
             System.out.println("BBBB");
             System.out.println(levelOrder(a));
         }

}
