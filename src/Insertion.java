import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Insertion {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of array : ");
        int n = sc.nextInt();

        int []arr = new int[n];
        int []newarr = new int[n+1];

        System.out.print("Enter values of array : ");
        for (int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }


        System.out.println(Arrays.toString(arr));

        System.out.print("At which index you want to insert number : ");
        int index = sc.nextInt();

        System.out.print("Enter value to put in that index : ");
        int value = sc.nextInt();

        for (int j=0; j<n+1; j++){
            if(j < index){
                newarr[j] = arr[j];
            }

            else if(j==index){
                newarr[j] = value;
            }

            else{
                newarr[j] = arr[j-1];
            }

        }

        System.out.println("New array is :");
        System.out.println(Arrays.toString(newarr));


    }

}
