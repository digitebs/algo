package tree;

import model.TreeNode;

import java.util.HashMap;


/** serialize using pre order traversal we need to add '#' to tag missing nodes
 *
 */
class TreeSerde {


    public void serialize(TreeNode tn){
        if(tn == null) {
            System.out.print("# ");
            return;
        }

        System.out.print(tn.val+" ");
        serialize(tn.left);
        serialize(tn.right);
    }


    // use reference
    public TreeNode deserialize(String[] arr, int[] t){
        if(arr[t[0]].equals("#")) {
            return null;
        }

        // 0
        // 1
        // 2
        TreeNode tn = new TreeNode(Integer.parseInt(arr[t[0]]));
        t[0] = t[0] +1;
        tn.left = deserialize(arr,t);
        t[0] = t[0] +1;
        tn.right = deserialize(arr,t);

        return tn;
    }



    public static void main(String[] args) {
        TreeSerde ts = new TreeSerde();

        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(6);


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
