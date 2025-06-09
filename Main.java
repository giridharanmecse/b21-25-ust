import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Map; 

public class Main{
    public static void main(String args[]){
        Integer data;
        Node root = null;
        BSTMethods bst = new BSTMethods();
        Integer choice;
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try{
        fis = new FileInputStream("input.txt");
        fos = new FileOutputStream("output.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));         
            do{
                System.out.println("1)insert");
                //bw.write("1)insert\n");               
                System.out.println("2)Inorder Traversal");
                //bw.write("2)Inorder Traversal\n");
                System.out.println("3)Preorder Traversal");
                //bw.write("3)Preorder Traversal\n");
                System.out.println("4)Postorder Traversal");
                //bw.write("4)Postorder Traversal\n");
                System.out.println("5) getMIn");
                //bw.write("5) getMIn\n");
                System.out.println("6) getMax");
                //bw.write("6) getMax\n");
                System.out.println("7) delete");
                //bw.write("7) delete\n");
                System.out.println("8) print leaf nodes");
                System.out.println("9) sum of leaf nodes");
                System.out.println("10) height of the BST");
                System.out.println("11) count nodes in the BST");
                System.out.println("12) Level order traversal");
                System.out.println("13) Vertical order traversal");
                //bw.write("8) print leaf nodes\n");
                System.out.println("Select your choice:");
                //bw.write("Select your choice:\n");
                choice = Integer.parseInt(br.readLine());                
                switch(choice){
                    case 1:
                        System.out.println("Enter the data to insert:");
                        //bw.write("Enter the data to insert:\n");
                        data = Integer.parseInt(br.readLine());
                        root = bst.insert(root, data);
                        break;
                    case 2:
                        System.out.println("Inorder Traversal:");
                        bw.write("Inorder Traversal:\n");
                        bst.inOrder(root,bw);
                        System.out.println();
                        bw.newLine();
                        break;
                    case 3:
                        System.out.println("Preorder Traversal:");
                        bw.write("Preorder Traversal:\n");
                        bst.preOrder(root,bw);
                        System.out.println();
                        bw.newLine();
                        break;
                    case 4:
                        System.out.println("Postorder Traversal:");
                        bw.write("Postorder Traversal:\n");
                        bst.postOrder(root,bw);
                        System.out.println();
                        bw.newLine();
                        break;
                    case 5:
                        Integer temp = bst.getMin(root);
                        System.out.println("Minimum value in the BST: " + (temp != null ? temp : "Tree is empty"));
                        bw.write("Minimum value in the BST: " + (temp != null ? temp : "Tree is empty") + "\n");
                        System.out.println();
                        break;
                    case 6:
                        Integer maxTemp = bst.getMax(root);
                        System.out.println("Maximum value in the BST: " + (maxTemp != null ? maxTemp : "Tree is empty"));
                        bw.write("Maximum value in the BST: " + (maxTemp != null ? maxTemp : "Tree is empty") + "\n");
                        System.out.println();
                        bw.newLine();
                        break;
                    case 7:
                        System.out.println("Enter the data to delete:");
                        bw.write("Enter the data to delete:\n");
                        data = Integer.parseInt(br.readLine());
                        bw.write(data + "\n");
                        root = bst.delete(root, data);
                        System.out.println("Deleted " + data + " from the BST.");
                        bw.write("Deleted " + data + " from the BST.\n");
                        break;
                    case 8:
                        System.out.print("Leaf nodes : ");
                        bw.write("Leaf nodes : \n");
                        bst.printLeafNodes(root,bw);
                        System.out.println();
                        bw.newLine();
                        break;
                    case 9:
                        data = bst.sumOfLeafNodes(root, bw);
                        System.out.println("Leaf Node Sum :"+ data);
                        bw.write("Leaf Node Sum :" + data + "\n");
                        //bw.newLine();
                        break;
                    case 10:
                        data = bst.height(root);
                        System.out.println("Height of the BST: " + data);
                        bw.write("Height of the BST: " + data + "\n");
                        System.out.println();
                        break;
                    case 11:
                        data = bst.coutNodes(root);
                        System.out.println("Number of nodes in the BST: " + data);
                        bw.write("Number of nodes in the BST: " + data + "\n");
                        break;
                    case 12:
                        System.out.println("Level order traversal:");
                        bw.write("Level order traversal:\n");
                        List<Integer> lor = bst.levelOrderTraversal(root);
                        for(Integer val : lor){
                            System.out.print(val + " ");
                            bw.write(val + " ");
                        }
                        bw.newLine();
                        System.out.println();
                        break;
                    case 13:
                        System.out.println("Vertical order traversal:");
                        bw.write("Vertical order traversal:\n");
                        Map<Integer,List<Integer>> mp = bst.verticalOrderTraversal(root);
                        for(Integer hd : mp.keySet()){
                            List<Integer> ll = mp.get(hd);
                            System.out.print(hd + ":");
                            bw.write(hd + ":");
                            for(Integer val : ll){
                                System.out.print(val + " ");
                                bw.write(val + " ");
                            }
                            System.out.println();
                            bw.newLine();
                        }
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        bw.write("Invalid choice. Please try again.\n");
                }
            }while(choice>=1 && choice<=13);
            br.close();
            bw.close();
        } catch(Exception e){
            System.out.println("An error occurred: " + e.getMessage());
        }
        
    }
}