import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class CompleteBinaryTree{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int index;
        int choice;
        int[] arr = new int[n+1];
        arr[0] = 0;
        int j = 1;
        String[] input = br.readLine().split(" ");
        for(String i : input){
            arr[j++] = Integer.parseInt(i);
        }
        do{
            System.out.println("1) print the Lc & RC");
            System.out.println("2) print the Parent");
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(br.readLine());
            switch (choice){
                case 1:
                System.out.println("Enter the Parent Index:");
                index = Integer.parseInt(br.readLine());
                System.out.println("Left Child: " + (2 * index < arr.length+1 ? arr[2 * index] : "No Left Child"));
                System.out.println("Right Child: " + (2 * index + 1 < arr.length+1 ? arr[2 * index + 1] : "No Right Child"));
                break; 
                case 2:
                System.out.println("Enter the Child Index:");
                index = Integer.parseInt(br.readLine());
                System.out.println("Parent: " + (index > 1 ? arr[index / 2] : "No Parent"));
                break;

            }
        }while(choice == 1 || choice == 2);
        System.out.println("Exiting...");
    }
}