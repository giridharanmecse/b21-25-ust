import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
public class BSTMethods {
    /*
     * 1) Insert
     * 2) Traversal
     *      2.1) Depth First Search (DFS)
     *          - Inorder - LRtR
     *          - Preorder  - RtLR
     *          - Postorder - LRRt
     *      2.2) Breadth First Search (BFS)
     * 3) search
     * 4) delete
     * 5) findMin
     * 6) findMax
     * 7) isEmpty
     * 8) size
     * 9) height
     *
     */

     public Node insert(Node root,Integer data){
        if(root == null){
            return new Node(data);
        } else {
            if(data <root.data){
                root.left = insert(root.left,data);
            } else {
                root.right = insert(root.right,data);
            }
            return root;
        }
     }

     public void inOrder(Node root,BufferedWriter bw) throws Exception {
        if(root != null){
            inOrder(root.left,bw);
            System.out.print(root.data + " ");
            bw.write(root.data + " ");
            inOrder(root.right,bw);
        }
     }

     public void preOrder(Node root,BufferedWriter bw) throws Exception {
        if(root != null){
            System.out.print(root.data + " ");
            preOrder(root.left,bw);
            preOrder(root.right,bw);
        }
     }

     public void postOrder(Node root,BufferedWriter bw) throws Exception {
        if(root != null){
            postOrder(root.left,bw);
            postOrder(root.right,bw);
            System.out.print(root.data + " ");
        }
     }

     public Integer getMin(Node root){
        if(root == null){
            return null;
        } else if(root.left == null){
            return root.data;
        } else {
            return getMin(root.left);
        }
     }

    public Integer getMax(Node root){
        if(root == null){
            return null;
        } else if(root.right == null){
            return root.data;
        } else {
            return getMax(root.right);
        }
    }

    public Node delete(Node root,Integer data){
        if(root == null){
            return null;
        } else if(data<root.data){
            root.left = delete(root.left,data);
        } else if(data> root.data){
            root.right = delete(root.right,data);
        } else{
            if(root.left ==null && root.right == null){
                return null;
            } else if(root.left == null){
                return root.right;
            } else if(root.right == null){
                return root.left;
            } else {
                int sucessor = getMax(root.left);
                root.data = sucessor;
                root.left = delete(root.left, sucessor);
            }
        }
        return root;

    }

    public boolean isEmpty(Node root) {
        return root == null;
    }

    public void printLeafNodes(Node root,BufferedWriter bw) throws Exception {
        if(root == null){
            return ;
        } else {
            if(root.left == null && root.right ==null){
                System.out.print(root.data+" ");
                bw.write(root.data+" ");
            } else {
                printLeafNodes(root.left,bw);
                printLeafNodes(root.right,bw);
            }
        }
    }

    public int sumOfLeafNodes(Node root, BufferedWriter bw) throws Exception {
        if(root == null){
            return 0;
        } else if(root.left == null && root.right == null){
            //System.out.print(root.data+" ");
            //bw.write(root.data+" ");
            return root.data;
        } else {
            return sumOfLeafNodes(root.left, bw) + sumOfLeafNodes(root.right, bw);
        }
    }

    public int height(Node root){
       if(root == null){
        return 0;
       } else {
            int lh = height(root.left);
            int rh= height(root.right);
            return Math.max(lh,rh) + 1;
       }
    }

    public int coutNodes(Node root){
        if(root == null){
            return 0;
        } else {
            return 1+coutNodes(root.left)+coutNodes(root.right);
        }
    }

    public List<Integer> levelOrderTraversal(Node root){
        List<Integer> res = new ArrayList<>();
        LinkedList<Node> qu = new LinkedList<>();
        qu.add(root);
        while(!qu.isEmpty()){
            Node cr = qu.poll();
            if(cr.left != null){
                qu.add(cr.left);
            }
            if(cr.right != null){
                qu.add(cr.right);
            }
            res.add(cr.data);
        }

        return res;
    }

    public void verticalOrderHelper(Node root, int hd, Map<Integer, List<Integer>> map) {
        if (root == null) {
            return;
        } else {
            if(map.containsKey(hd)){
                List<Integer> hdList = map.get(hd);
                hdList.add(root.data);
                map.put(hd,hdList);
            } else {
                List<Integer> lt = new ArrayList<>();
                lt.add(root.data);
                map.put(hd,lt);
            }
            verticalOrderHelper(root.left, hd - 1, map);
            verticalOrderHelper(root.right, hd + 1, map);
        }
    }

    public Map<Integer, List<Integer>> verticalOrderTraversal(Node root) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        verticalOrderHelper(root,0,map);
        return map;
    }

}
