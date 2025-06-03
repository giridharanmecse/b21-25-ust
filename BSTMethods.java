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

     public void inOrder(Node root){
        if(root != null){
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
     }

     public void preOrder(Node root){
        if(root != null){
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
     }

     public void postOrder(Node root){
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
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
}
