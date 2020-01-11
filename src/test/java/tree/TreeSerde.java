package tree;

import model.Node;


/** serialize using pre order traversal we need to add '#' to tag missing nodes
 *
 */
class TreeSerde {


    public void serialize(Node tn){
        if(tn == null) {
            System.out.print("# ");
            return;
        }

        System.out.print(tn.val+" ");
        serialize(tn.left);
        serialize(tn.right);
    }


    // use reference
    public Node deserialize(String[] arr, int[] t){
        if(arr[t[0]].equals("#")) {
            return null;
        }

        // 0
        // 1
        // 2
        Node tn = new Node(Integer.parseInt(arr[t[0]]));
        t[0] = t[0] +1;
        tn.left = deserialize(arr,t);
        t[0] = t[0] +1;
        tn.right = deserialize(arr,t);

        return tn;
    }



    public static void main(String[] args) {
        TreeSerde ts = new TreeSerde();

        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        Node c = new Node(4);
        Node d = new Node(5);
        Node e = new Node(6);


        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        d.left = e;

        ts.serialize(root);

        System.out.println();
        String s ="1 2 4 # # 5 6 # # # 3 # #";
        String[] arr = s.split(" ");
        int[] t = {0}; // need to maintain a single counter
         root = ts.deserialize(arr, t);
        ts.serialize(root);
    }
}
