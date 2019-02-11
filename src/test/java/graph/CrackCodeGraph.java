package graph;

import model.TreeNode;
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

         public ArrayList<ArrayList<Integer>> levelOrder(TreeNode a) {
            // HashSet<TreeNode> end = new HashSet<>();
             ArrayList<ArrayList<Integer>> res = new ArrayList<>();
             ArrayList<Integer> data = new ArrayList<>();
             Queue<TreeNode> q = new LinkedList<>();
             q.add(a);
             //end.add(a);
             while (!q.isEmpty()) {
                 int ln = q.size();
                 while(ln --> 0) {
                     TreeNode tn = q.poll();
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
             TreeNode a = new TreeNode(3);
             a.left = new TreeNode(9);
             a.right = new TreeNode(20);
             a.left.left = new TreeNode(6);
             a.left.right = new TreeNode(8);
             a.left.left.right = new TreeNode(9);
             //a.right.left = new TreeNode(15);
             //a.right.right = new TreeNode(7);
             System.out.println("BBBB");
             System.out.println(levelOrder(a));
         }

}
