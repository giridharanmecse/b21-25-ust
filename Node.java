public class Node {
    Integer data;
    Node left;
    Node right;

    public Node(){
    }

    /*
    struct student{
        int roll_no;
        char name[10];
        char address[10];
    }
     * int * arr = (int *)malloc(sizeof(int)*n);
     * struct student * arr = (struct student *)malloc(sizeof(struct student)*size);
     * struct student * arr1 = (struct student *)calloc(sizeof(struct student),size);
     * 
     * Node n = new Node();
     * 
     */

    public Node(Integer data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public Integer getData() {
        return data;
    }
}