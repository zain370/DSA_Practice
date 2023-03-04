import java.util.Arrays;
import java.util.Scanner;

public class Delete {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of array :  ");
        int n = sc.nextInt();

        int []arr = new int[n];
        int []newarr = new int[n-1];

        System.out.print("Enter the elements of array : ");
        for (int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Which element in array you want to delete : ");
        int num = sc.nextInt();

        for (int j=0,k=0; j<n; j++){
            if(arr[j]!=num){
                newarr[k] = arr[j];
                k++;
            }
        }

        System.out.println("Array Before Deleting " + Arrays.toString(arr));
        System.out.println("Array  After Deleting " + Arrays.toString(newarr));
        for (int x:newarr) {
            System.out.print(x+", ");
        }
    }
}
