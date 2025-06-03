import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String args[]){
        Integer data;
        Node root = null;
        BSTMethods bst = new BSTMethods();
        Integer choice;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            do{
                System.out.println("1)insert");
                System.out.println("2)Inorder Traversal");
                System.out.println("3)Preorder Traversal");
                System.out.println("4)Postorder Traversal");
                System.out.println("5) getMIn");
                System.out.println("6) getMax");
                System.out.println("7) delete");;
                System.out.println("Select your choice:");
                choice = Integer.parseInt(br.readLine());
                switch(choice){
                    case 1:
                        System.out.println("Enter the data to insert:");
                        data = Integer.parseInt(br.readLine());
                        root = bst.insert(root, data);
                        break;
                    case 2:
                        System.out.println("Inorder Traversal:");
                        bst.inOrder(root);
                        System.out.println();
                        break;
                    case 3:
                        System.out.println("Preorder Traversal:");
                        bst.preOrder(root);
                        System.out.println();
                        break;
                    case 4:
                        System.out.println("Postorder Traversal:");
                        bst.postOrder(root);
                        System.out.println();
                        break;
                    case 5:
                        Integer temp = bst.getMin(root);
                        System.out.println("Minimum value in the BST: " + (temp != null ? temp : "Tree is empty"));
                        break;
                    case 6:
                        Integer maxTemp = bst.getMax(root);
                        System.out.println("Maximum value in the BST: " + (maxTemp != null ? maxTemp : "Tree is empty"));
                        break;
                    case 7:
                        System.out.println("Enter the data to delete:");
                        data = Integer.parseInt(br.readLine());
                        root = bst.delete(root, data);
                        System.out.println("Deleted " + data + " from the BST.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }while(choice>=1 && choice<=7);

        } catch(Exception e){
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}