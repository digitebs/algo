import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by johnlim on 10/2/16.
 */

class TestGrab {

    class Node{
        Node(int value){
            this.value=value;
            

            next.stream().sorted().collect(Collectors.toList());

        }

        @Override
        public boolean equals(Object obj) {
            return value==((Node)obj).value;
        }

        int value;
        List<Node> next = new ArrayList<>();



    }

    public int[] solutionD(int[] T) {

        Node capital=null;
        Node[] nodes = new Node[T.length];
        for(int i=0; i < T.length;i++){
           if(nodes[i]== null) {
               nodes[i] = new Node(i);
           }
            if(nodes[T[i]]==null){
                nodes[T[i]] = new Node(T[i]);
            }

            if(i== T[i]){
                capital=nodes[T[i]];
            }else {

                //nodes[i].next.add(nodes[A[i]]);
                nodes[T[i]].next.add(nodes[i]);
            }
        }


       List result= Arrays.asList(new Integer[nodes.length-1]);
         traverse(capital,result,0);

        int[] ret = new int[result.size()];
        for (int i=0; i < ret.length; i++)
        {
            if(result.get(i)==null)
                ret[i]=0;
            else {
                ret[i] = (int) result.get(i);
            }
            System.out.println(ret[i]);

        }

        return ret;
    }

    public void traverse(Node current,List<Integer> result,int i){

        if(i < result.size()) {
            // System.out.println(i + " " + result.size());

            // handel teh 1st level
            if(i==0) {
                result.set(i, current.next.size());
                i++;
            }

            int c=i;
            for (int j = 0; j < current.next.size(); j++) {


                if (result.get(i) == null) {
                    //System.out.println("current "+i+" "+result.get(i)+" "+  i+ " "+current.value+" "+ current.next.size());
                    result.set(i, current.next.get(j).next.size());
                } else {
                    //System.out.println("currentadd "+i+" "+result.get(i)+" "+ current.value+" "+ current.next.size());
                    result.set(i, result.get(i) + current.next.get(j).next.size());
                }

                traverse(current.next.get(j), result, ++c);
            }
        }


    }

    public int solutionp(int[] A) {
        int cost;
        int totalCost=0;
        for(int i=0; i < A.length;i++){
            cost=2;
            for(int j=6; j >=3;j--){
                    if ((i+j) < A.length && A[i + j] - A[i] <= 7) {
                        cost = 7;
                        i = i + j;
                        break;
                    }
            }
            totalCost+=cost;
        }


        if(totalCost> 25){
            return 25;
        }
        return totalCost;

    }



    public static void main(String args[]){
        TestGrab s= new TestGrab();
        //System.out.println(s.solution(new int[]{1,2,4,5,7,29,30}));
        System.out.println(s.solutionp(new int[]{1,2,4,5,7,29,30}));
        //System.out.println(s.solutionp(new int[]{1,4,7,10,11,14,29,30}));
     //   System.out.println(s.solutionD(new int[]{9,1,4,9,0,4,8,9,0,1}));
    }
}

