import java.util.Arrays;
import java.util.Scanner;

public class CutPaste {
    static int n=0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of array :  ");
        n = sc.nextInt();

        int[] arr = new int[n];
        int[] new_arr = new int[n-1];

        System.out.print("Enter the elements of array : ");
        for (int i = 0; i <n; i++) {
            arr[i] = sc.nextInt();
        }


        for (int j=0; j<=n; j++){

            System.out.println(Arrays.toString(deleteLargest(arr,largestNumber(arr),n--)));

        }

    }



    // Method for finding the largest Number from array
    public static int largestNumber(int [] array){
        int maxNum = 0;
        for (int i=0; i<n; i++){
            if (array[i] > maxNum ){
                maxNum = array[i];
            }
        }
        return maxNum;
    }


    // Method for deleting the largest number from array
    public static int[] deleteLargest(int[] array, int temp, int n){
        int[] new_array = new int[n-1];
        for (int i=0,k=0; i<n;i++){
            if (array[i] != temp) {
                new_array[k] = array[i];
                k++;
            }
        }
      //  System.out.println(deleteLargest(new_array,largestNumber(new_array),));
        return new_array;

    }

    //Method for storing deleted element
  //  public static int[] storeDeleted(int x){}




}
